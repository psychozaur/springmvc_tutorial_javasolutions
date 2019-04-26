package main.java.part1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@ControllerAdvice // wyjątek obsłuzony globalnie
public class ExceptionController {

    @ExceptionHandler(Exception.class)
    public String handleException(Exception e){

        return "handleException";
    }
}
