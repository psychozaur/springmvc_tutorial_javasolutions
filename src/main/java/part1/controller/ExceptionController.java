package main.java.part1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExceptionController {

    @RequestMapping(value = "/runtimeException")
    public String runtimeException(){

        throw new RuntimeException();
    }

    @ExceptionHandler(RuntimeException.class)
    public String handleException(RuntimeException e){
        e.getMessage(); // taka ciekawostka, można dodać do modelu
        return "handleException";
    }
}
