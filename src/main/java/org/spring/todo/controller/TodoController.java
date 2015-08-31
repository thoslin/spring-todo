package org.spring.todo.controller;

import org.spring.todo.model.Todo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/todo")
public class TodoController {

    @RequestMapping(method = RequestMethod.GET)
    public String index(Todo todo, @RequestParam(value = "version", required = false, defaultValue = "0.1") String version, Model model) {
        model.addAttribute("version", version);
        return "list";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String add(@Valid Todo todo, BindingResult result, ModelMap modelMap) {
//        String description = webRequest.getParameter("description");
//        System.out.println("Got a post request: " + description);
        System.out.println("Awesome data-binding: " + todo.getDescription());

        if(result.hasErrors()) {
            return "list";
        }

        Todo another_todo = new Todo("example item");
        List<Todo> todo_list = new ArrayList<Todo>();
        todo_list.add(todo);
        todo_list.add(another_todo);

        modelMap.addAttribute("todo_list", todo_list);

        return "list";
    }
}
