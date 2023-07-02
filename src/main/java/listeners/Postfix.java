package listeners;

import java.util.LinkedList;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Postfix {
    private static StringBuilder mathPostfix = new StringBuilder();

    private static LinkedList<String> operators = new LinkedList<>();
    private static Stack<String> operatorsStack = new Stack<>();

    static {
        operators.add("+");
        operators.add("-");
        operators.add("/");
        operators.add("*");
        operators.add("^");
        operators.add("√");
        operators.add("∛");
        operators.add("%ё");
    }

    public static String convert(String mathInfix) {
        operatorsStack.clear();
        mathPostfix.setLength(0);

        Matcher matcherMath = getMatcherMath(mathInfix);
        while (matcherMath.find()) {
            String mathElement = matcherMath.group();
            if (isNumeric(mathElement)) {
                mathPostfix.append(mathElement).append(" ");
            } else if (mathElement.equals("(")) {
                operatorsStack.add(mathElement);
            } else if (mathElement.equals(")")) {
                while (!operatorsStack.peek().equals("(")) {
                    mathPostfix.append(operatorsStack.pop()).append(" ");
                }
                operatorsStack.pop();
            } else {
                while (!operatorsStack.isEmpty() && getOperatorPriority(operatorsStack.peek()) >= getOperatorPriority(mathElement)) {
                    mathPostfix.append(operatorsStack.pop()).append(" ");
                }
                operatorsStack.push(mathElement);
            }
        }
        while (!operatorsStack.isEmpty()){
            mathPostfix.append(operatorsStack.pop()).append(" ");
        }
        return mathPostfix.toString();
    }

    private static int getOperatorPriority(String operator) {
        return switch (operator) {
            case "^", "√", "∛", "%" -> 3;
            case "*", "/" -> 2;
            case "+", "-" -> 1;
            default -> 0;
        };
    }

    static boolean isNumeric(String mathElement) {
        return mathElement.matches(getPatternStringDigits());
    }

    private static Matcher getMatcherMath(String mathInfix) {
        Pattern patternMath = Pattern.compile(getPatternString());
        return patternMath.matcher(mathInfix);
    }

    private static String getPatternString() {
        return getPatternStringDigits() + "|" + getPatternStringOperators() + "|" + gerPatternStringBrackets();
    }

    private static String gerPatternStringBrackets() {
        return "([\\(\\)])";
    }

    private static String getPatternStringOperators() {
        StringBuilder sb = new StringBuilder("([");
        for (String operator : operators){
            sb.append("\\").append(operator);
        }
        return sb.append("])").toString();
    }

    private static String getPatternStringDigits() {
        return "(\\d+((\\.\\d+)?)+)";
    }


}
