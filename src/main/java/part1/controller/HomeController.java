package main.java.part1.controller;

import main.java.part1.pojo.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @RequestMapping(value = "/")
    public String home(Model model){

        return "home"; // nazwa powinna być zgodna z nazwą pliku .jsp
    }

}
