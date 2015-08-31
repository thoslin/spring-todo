package org.spring.todo.controller;

import org.spring.todo.model.Todo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/todo")
public class TodoController {

    @RequestMapping(method = RequestMethod.GET)
    public String index(@RequestParam(value = "version", required = false, defaultValue = "0.1") String version, Model model) {
        model.addAttribute("version", version);
        return "list";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String add(WebRequest webRequest, @ModelAttribute Todo todo, ModelMap modelMap) {
        String description = webRequest.getParameter("description");
        System.out.println("Got a post request: " + description);
        System.out.println("Awesome data-binding: " + todo.getDescription());

        Todo another_todo = new Todo(description = "example item");
        List<Todo> todo_list = new ArrayList<Todo>();
        todo_list.add(todo);
        todo_list.add(another_todo);

        modelMap.addAttribute("todo_list", todo_list);

        return "list";
    }
}
