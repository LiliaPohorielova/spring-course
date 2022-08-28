package ua.com.pogorelova.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    @GetMapping("/calculator")
    public String calculating(@RequestParam(value = "a", required = false) String a,
                              @RequestParam(value = "b", required = false) String b,
                              @RequestParam(value = "operation", required = false) String operation,
                              Model model) {

        if (a == null || b == null)
            model.addAttribute("message", "Please, enter two values");
        else if (operation == null || !isCorrectOperation(operation))
            model.addAttribute("message", "Please, enter correct operation");
        else
            model.addAttribute("message",
                    "The result of: " +
                            a + " " + operation + " " + b + " = " + getResult(a, b, operation));
        return "calculator/calculator";
    }

    private String getResult(String a, String b, String operation) {
        try {
            double num1 = Double.parseDouble(a);
            double num2 = Double.parseDouble(b);
            switch (operation) {
                case "add": return Double.toString(num1 + num2);
                case "sub": return Double.toString(num1 - num2);
                case "mul": return Double.toString(num1 * num2);
                case "div": return Double.toString(num1 / num2);
            }
        } catch (NumberFormatException e) {
            return "Error!";
        }
        return "Error!";
    }

    private boolean isCorrectOperation(String operation) {
        return switch (operation) {
            case "div", "add", "mul", "sub" -> true;
            default -> false;
        };
    }
}
