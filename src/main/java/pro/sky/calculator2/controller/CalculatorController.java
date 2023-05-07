package pro.sky.calculator.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {
    @GetMapping(value = "/calculator",produces = MediaType.TEXT_HTML_VALUE)
    public String hello(){
        return "Добро пожаловать в калькулятор";
    }
}
