package listeners;

import java.util.Stack;

public class Calculation {
    private static Stack<Double> numbers = new Stack<>();
    private static String mathPostfix;

    public static double parse(String mathInfix) {
        mathPostfix = Postfix.convert(mathInfix);
        var mathArr =  mathPostfix.split("\s");

        for (String mathElement : mathArr) {
            if (Postfix.isNumeric(mathElement)) {
                numbers.push(Double.parseDouble(mathElement));
                continue;
            }
            if (mathElement.equals("√")) {
                double num1 = numbers.pop();
                numbers.push(Math.sqrt(num1));
            } else if (mathElement.equals("∛")) {
                double num1 = numbers.pop();
                numbers.push(Math.cbrt(num1));
            } else if (mathElement.equals("%")) {
                if(numbers.isEmpty()){
                    return 0.000006;
                } else {
                    double num1 = numbers.pop();
                    if (numbers.isEmpty()){
                        return 0.000006;
                    } else {
                        double num2 = numbers.pop();
                        double res = Math.abs((num1 * num2) / 100);
                        numbers.push(num2);
                        numbers.push(res);
                    }
                }
            } else {
                double num2 = numbers.pop();
                double num1 = numbers.pop();
                numbers.push(calculation(num1, num2, mathElement));
            }
        }
        return numbers.pop();
    }

    private static Double calculation(double num1, double num2, String operator) {
        return switch (operator) {
            case "*" -> num1 * num2;
            case "/" -> num1 / num2;
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            case "^" -> Math.pow(num1, num2);
            default -> 0.0;
        };
    }
}
