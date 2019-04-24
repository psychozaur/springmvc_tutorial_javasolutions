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

        List<Product> products = getProducts();

        model.addAttribute("products", products);
        model.addAttribute("nick","Marryb");
        return "home"; // nazwa powinna być zgodna z nazwą pliku .jsp
    }

    private List<Product> getProducts(){
        List<Product> products = new ArrayList<>();
        products.add(new Product("Lucek","chemia gospodarcza"));
        products.add(new Product("Pucek","artykuly do mycia"));
        products.add(new Product("Mopex","artykuly do mycia"));
        return products;
    }
}
