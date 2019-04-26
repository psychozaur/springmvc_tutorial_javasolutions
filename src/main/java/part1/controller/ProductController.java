package main.java.part1.controller;

import main.java.part1.manager.ProductManager;
import main.java.part1.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class ProductController {

    @Autowired
    private ProductManager productManager;

    @GetMapping(value = "/products/{category}")
    public String products(Model model, @PathVariable("category") String category,
                           @MatrixVariable(value = "sortBy", pathVar = "category", required = false)
                                   List<String> sortCriteria){

        List<Product> products;
        if(category.equals("ALL")){
            products = productManager.findAll();
        } else {
            products = productManager.findByCategory(category);
        }

        products = getSorted(products, sortCriteria);

        List<String> categories = productManager.getCategories();

        model.addAttribute("products", products);
        model.addAttribute("categories",categories);
        return "products";
    }

    private List<Product> getSorted(List<Product> products, List<String> sortCriteria) {

        if (null == sortCriteria){
            return products;
        }

        Comparator<Product> comparator = null;

        if(sortCriteria.contains("name")){
            comparator = Comparator.comparing(Product::getName);
        }

        if(sortCriteria.contains("name") && sortCriteria.contains("category")){
            comparator = Comparator.comparing(Product::getName).thenComparing(Product::getCategory);
        }

        return products.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }

    private List<Product> getByCount(String count, List<Product> products){

        List<Product> result = new ArrayList<>();
        Integer countAsInt = Integer.valueOf(count);
        IntStream.range(0, countAsInt).forEach(index -> result.add(products.get(index)));

        return result;
    }

}
