package main.java.part1.controller;

import main.java.part1.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpSession;

@Controller
public class LogoutController {



    @GetMapping(value = "/logout")
    public String logout (Model model, HttpSession session){

        session.invalidate();
        return "redirect:/";
    }

}
