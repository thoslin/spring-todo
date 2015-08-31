package org.spring.todo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/todo")
public class TodoController {

    @RequestMapping(method = RequestMethod.GET)
    public String index(@RequestParam(value = "version", required = false, defaultValue = "0.1") String version, Model model) {
        model.addAttribute("version", version);
        return "list";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String add() {
        System.out.println("Got a post request!");
        return "list";
    }
}
