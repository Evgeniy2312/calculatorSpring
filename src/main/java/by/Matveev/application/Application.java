package by.Matveev.application;

import by.Matveev.application.service.Calculator;
import by.Matveev.application.service.operarion.Operation;
import by.Matveev.application.utils.Console;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Application {

    private Console console;
    private Calculator calculator;
    private boolean isStart = true;

    @Autowired
    public Application(Console console, Calculator calculator) {
        this.console = console;
        this.calculator = calculator;
    }

    public Application() {
    }

    public void run(){
        System.out.println("Hi friend!");
        while (isStart){
            double num1 = console.getDouble("Enter the first number");
            double num2 = console.getDouble("Enter the second number");
            String type = chooseType();
            if(console.testDivisionOnZero(num2,type)){
                System.out.println("You can't divide by zero ");
                continue;
            }
            System.out.println("Result: " + calculator.getResult(num1, num2, type));
            startAgain();
        }
        System.out.println("Goodbye friend!");

    }

    private String chooseType(){
        for(Operation operation : calculator.getOperations() ){
            System.out.print(operation.getName() +  " ");
        }
        return console.getMessage("Choose the type of operation");
    }

    private boolean startAgain(){
        double choose = console.getDouble("Enter the 1 to start again: ");
        if(choose != 1.0){
            isStart = false;
        }
        return isStart;
    }
}
