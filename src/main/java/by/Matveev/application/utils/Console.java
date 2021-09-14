package by.Matveev.application.utils;

import org.springframework.stereotype.Component;

import java.util.Scanner;
@Component
public class Console {
    private final static Scanner scanner = new Scanner(System.in);

    public boolean testDivisionOnZero(double num1, String type){
        return num1 == 0 && type.equals("/");
    }

    public double getDouble(){
        if(scanner.hasNextDouble()){
            double number = scanner.nextDouble();
            scanner.nextLine();
            return number;
        }
        System.out.println("Incorrectly enter the number");
        scanner.nextLine();
        return getDouble();
    }

    public double getDouble(String message){
        System.out.println(message);
        return getDouble();
    }

    public String getMessage(String message){
        System.out.println(message);
         return scanner.nextLine();
    }
}
