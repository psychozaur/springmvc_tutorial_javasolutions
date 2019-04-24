package main.java.part1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping(value = "/user")
    public String home(Model model){

        model.addAttribute("nick","Marryb");
        return "home"; // nazwa powinna być zgodna z nazwą pliku .jsp
    }
}
