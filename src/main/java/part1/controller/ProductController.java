package main.java.part1.controller;

import main.java.part1.manager.ProductManager;
import main.java.part1.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Controller
public class ProductController {

    @Autowired
    private ProductManager productManager;

    @GetMapping(value = "/products/{category}")
    public String products(Model model, @PathVariable("category") String category,
                           @RequestParam(value = "count", required=false, defaultValue = "1") String count){

        List<Product> products;
        if(category.equals("ALL")){
            products = productManager.findAll();
        } else {
            products = productManager.findByCategory(category);
        }

        products = getByCount(count, products);

        List<String> categories = productManager.getCategories();

        model.addAttribute("products", products);
        model.addAttribute("categories",categories);
        return "products";
    }

    private List<Product> getByCount(String count, List<Product> products){

        List<Product> result = new ArrayList<>();
        Integer countAsInt = Integer.valueOf(count);
        IntStream.range(0, countAsInt).forEach(index -> result.add(products.get(index)));

        return result;
    }

}
