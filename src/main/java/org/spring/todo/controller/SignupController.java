package org.spring.todo.controller;


import org.spring.todo.dao.UserDao;
import org.spring.todo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping(value="/signup")
public class SignupController {
    @Autowired
    private UserDao userDao;

    @RequestMapping(method = RequestMethod.GET)
    public String showForm(User user) {
        return "signup";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String signup(@Valid User user, BindingResult result) {
        if(result.hasErrors()) {
            return "signup";
        }

        user.setEnabled(true);
        userDao.saveUser(user);
        // log user in automatically
        final UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
                user.getUsername(), user.getPassword(), user.getAuthorities());
        auth.setDetails(user);
        SecurityContextHolder.getContext().setAuthentication(auth);

        return "redirect:todo";
    }
}
