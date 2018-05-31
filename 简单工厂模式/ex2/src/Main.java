import java.util.ResourceBundle;
import java.util.Scanner;
public class Main {
    public static void main(String args[]) throws Exception{
        Calculator calculator;
        ResourceBundle rb = ResourceBundle
                .getBundle("type");
        String type = rb.getString("TYPE");
        calculator = Calculator.fectory(type);
        Scanner s = new Scanner(System.in);
        System.out.println("Please input number a:");
        int a = s.nextInt();
        System.out.println("Please input number b:");
        int b = s.nextInt();
        int c = calculator.operator(a,b);
        System.out.println("Calculate result:");
        System.out.println(c);
    }
}

abstract class Calculator{
    static Calculator fectory(String type) throws RuntimeException{
        switch (type){
            case "Add":
                return new AddCalculator();
            case "Minus":
                return new MinusCalculator();
            default:
                System.out.println("No such Calculator, check your properties file.");
                throw new RuntimeException("No such Calculator, check your properties file.");
        }
    }
    int operator(int a,int b){return 0;}
}

class AddCalculator extends Calculator{
    int operator(int a,int b){
        return a + b;
    }
}

class MinusCalculator extends Calculator{
    int operator(int a,int b){
        return a - b;
    }
}
