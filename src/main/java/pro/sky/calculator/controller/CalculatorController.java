package pro.sky.calculator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.calculator.service.CalculatorService;

@RestController
@RequestMapping( "/calculator")
public class CalculatorController {
     private final CalculatorService calculatorService;
     public CalculatorController(CalculatorService calculatorService){
         this.calculatorService = calculatorService;
     }
    @GetMapping
    public String hello(){
        return "Добро пожаловать в калькулятор";
    }
    @GetMapping("/plus")
    public String plus(@RequestParam(value = "num1",required = false)Integer a,
          @RequestParam(value = "num2",required = false) Integer b) {
        return buildView(a, b,  "+");
    }
    @GetMapping("/minus")
    public String minus(@RequestParam(value = "num1",required = false)Integer a,
        @RequestParam(value = "num2",required = false) Integer b) {
        return buildView(a, b, "-");
    }
    @GetMapping("/multiply")
    public String multiply(@RequestParam(value = "num1",required = false)Integer a,
       @RequestParam(value = "num2",required = false) Integer b) {
        return buildView(a, b,  "*");

    }
    @GetMapping("/divide")
    public String divide(@RequestParam(value = "num1",required = false)Integer a,
        @RequestParam(value = "num2",required = false) Integer b) {
        return buildView(a, b, "/");
    }
    private String buildView ( Integer a,
        Integer b,
        String operation)    {
     if (a == null || b == null) {
          return "Не передан один из параметров!";
     }
     if ("/".equals(operation) && b == 0) {
         return "На ноль делить нельзя!";
     }
     Number result;
    switch (operation)  {
         case  "-":
             result = calculatorService.minus(a,b);
             break;
         case "*":
             result = calculatorService.multiply(a,b);
             break;
         case "/":
             result = calculatorService.divide(a,b);
             break;
         default:
             result = calculatorService.plus(a,b);
     }
     return a + " " + operation + " " + b + "=" + result;
    }
}


