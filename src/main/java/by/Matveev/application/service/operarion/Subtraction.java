package by.Matveev.application.service.operarion;

import org.springframework.stereotype.Component;

@Component
public class Subtraction implements Operation{
    private String name = "-";

    public String getName() {
        return name;
    }

    @Override
    public double calculate(double num1, double num2) {
        return num1 - num2;
    }
}
