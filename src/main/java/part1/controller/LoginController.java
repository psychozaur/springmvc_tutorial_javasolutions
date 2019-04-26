package main.java.part1.controller;

import main.java.part1.pojo.User;
import main.java.part1.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("loggedUser")
public class LoginController {

    @PostMapping(value = "/login")
    public String postLogin(Model model, @ModelAttribute("user") User user){

        model.addAttribute("loggedUser", user);
        return "redirect:user_page";
    }

    @GetMapping(value = "/login")
    public String login (Model model){

        model.addAttribute("user", new User());
        return "login";
    }

}
