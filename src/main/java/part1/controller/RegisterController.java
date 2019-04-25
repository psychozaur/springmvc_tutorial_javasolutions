package main.java.part1.controller;

import main.java.part1.pojo.Product;
import main.java.part1.pojo.User;
import main.java.part1.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@Controller
public class RegisterController {

    @Autowired
    UserValidator userValidator;

    @InitBinder
    protected void initBinder(WebDataBinder binder){
        binder.addValidators(userValidator);
    }

    @PostMapping(value = "/register")
    public String postRegister(@ModelAttribute("user") @Validated User user, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "register";
        }
        return "home";
    }

    @GetMapping(value = "/register")
    public String register (Model model){

        model.addAttribute("user", new User());
        return "register";
    }

}
