package main.java.part1.manager;

import main.java.part1.pojo.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductManager {

    private List<Product> products;

    public ProductManager() {
        this.products = prepareProducts();
    }

    private List<Product> prepareProducts(){

        List<Product> products = new ArrayList<>();
        Product prod = new Product("T-Shirt1", "koszulki");
        Product prod2 = new Product("T-Shirt2", "koszulki");
        Product prod3 = new Product("Trousers1", "spodnie");
        Product prod4 = new Product("Trousers2", "spodnie");

        products.add(prod);
        products.add(prod2);
        products.add(prod3);
        products.add(prod4);

        return products;
    }

    public List<Product> findAll() {
        return products;
    }

    public List<Product> findByCategory(String categoryName){

        return products.stream()
                .filter(product -> categoryMatch(categoryName, product))
                .collect(Collectors.toList());
    }

    private boolean categoryMatch(String category, Product product){

        String productCategory = product.getCategory();
        return category.equals(productCategory);
    }

    public List<String> getCategories() {

        List<String> result = new ArrayList<>();
        result.add("koszulki");
        result.add("spodnie");
        return result;
    }
}
