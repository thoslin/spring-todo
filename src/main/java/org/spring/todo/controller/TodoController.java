package org.spring.todo.controller;

import org.spring.todo.dao.TodoDao;
import org.spring.todo.model.Todo;
import org.spring.todo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/todo")
public class TodoController {
    @Autowired
    private TodoDao todoDao;

    @RequestMapping(method = RequestMethod.GET)
    public String index(Todo todo, Principal principal, @RequestParam(value = "version", required = false, defaultValue = "0.1") String version, Model model) {
        //model.addAttribute("version", version);
        if(principal != null) {
            User user = new User();
            user.setUsername(principal.getName());
            List todoList = todoDao.getTodoListByUser(user);
            model.addAttribute("todo_list", todoList);
        }
        return "list";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String add(@Valid Todo todo, Principal principal, BindingResult result, ModelMap modelMap) {
//        String description = webRequest.getParameter("description");
//        System.out.println("Got a post request: " + description);
//        System.out.println("Awesome data-binding: " + todo.getDescription());

        if(result.hasErrors()) {
            modelMap.addAttribute("todo_list", todoDao.getTodoList());
            return "list";
        }

        if(principal != null) {
            User user = new User();
            user.setUsername(principal.getName());
            todo.setUser(user);
            todoDao.saveTodo(todo);
        }
        //else: save to cookie/session
//        Todo another_todo = new Todo("example item");
//        List<Todo> todo_list = new ArrayList<Todo>();
//        todo_list.add(todo);
//        todo_list.add(another_todo);

        return "redirect:todo";
    }

    @RequestMapping(value="/{todoId}", method = RequestMethod.DELETE)
    public @ResponseBody String delete(@PathVariable String todoId) {
        int id = Integer.parseInt(todoId);
        todoDao.deleteTodo(id);
        return "Ok";
    }
}
