package by.Matveev.application.service;

import by.Matveev.application.service.operarion.Operation;
import org.springframework.stereotype.Component;

import javax.naming.InvalidNameException;
import java.util.List;


@Component
public class Calculator {

    private List<Operation> operations;

    public Calculator(List<Operation> operations) {
        this.operations = operations;
    }

    public List<Operation> getOperations() {
        return operations;
    }

    public double getResult(double num1, double num2, String type){
        Operation operation = null;
        try {
            operation = getOperation(type);
        } catch (InvalidNameException e) {
            System.out.println("Operation not found!");
        }
        return operation.calculate(num1,num2);
    }

    private Operation getOperation(String name) throws InvalidNameException {
        return operations.stream().filter(operations -> operations.getName().equals(name)).findAny().orElseThrow(InvalidNameException::new);
    }
}
