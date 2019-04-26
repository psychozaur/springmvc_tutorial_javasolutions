package main.java.part1.controller;

import main.java.part1.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserPageController {

    @GetMapping(value = "/user_page")
    public String userPage (Model model, @SessionAttribute("loggedUser") User user){

        model.addAttribute("usr",user);
        return "user_page";
    }

    @ExceptionHandler(ServletRequestBindingException.class)
    public String handle(){

        return "redirect:/login";
    }

}
