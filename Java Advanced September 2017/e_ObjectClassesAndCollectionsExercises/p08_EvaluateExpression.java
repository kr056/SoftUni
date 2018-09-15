package e_ObjectClassesAndCollectionsExercises;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class p08_EvaluateExpression {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<String> operators = new ArrayDeque<>();
        ArrayDeque<String> expression = new ArrayDeque<>();

        String[] input = scan.nextLine().split(" ");
        Map<String, Integer> priorities = new HashMap<>();
        priorities.put("*", 3);
        priorities.put("/", 3);
        priorities.put("+", 2);
        priorities.put("-", 2);
        priorities.put("(", 1);

        for (String anInput : input) {
            try {
                double num = Double.parseDouble(anInput);
                expression.addLast(anInput);
            } catch (Exception e) {
                switch (anInput) {
                    case "x":
                        expression.addLast(anInput);
                        break;
                    case "(":
                        operators.push(anInput);
                        break;
                    case ")":
                        String symbol = operators.pop();
                        while (!symbol.equals("(")) {
                            expression.addLast(symbol);
                            symbol = operators.pop();
                        }
                        break;
                    default:
                        while (!operators.isEmpty() && priorities.get(operators.peek()) >= priorities.get(anInput)) {
                            expression.addLast(operators.pop());
                        }
                        operators.push(anInput);
                        break;
                }
            }
        }

        while (!operators.isEmpty()) {
            expression.addLast(operators.pop());
        }

        while (expression.size() >= 1) {
            String token = expression.pop();
            try {
                double a = Double.parseDouble(token);
                operators.push(token);
            } catch (Exception e) {
                String op1 = operators.pop();
                String op2 = operators.pop();
                String result = doMath(token, op1, op2);
                operators.push(result);
            }
        }
        System.out.printf("%.2f", Double.parseDouble(operators.peek()));
    }

    private static String doMath(String token, String op1, String op2) {
        switch (token) {
            case "*":
                return Double.toString(Double.parseDouble(op1) * Double.parseDouble(op2));
            case "/":
                return Double.toString(Math.max(Double.parseDouble(op2), Double.parseDouble(op2)) /
                        Math.min(Double.parseDouble(op1), Double.parseDouble(op2)));
            case "+":
                return Double.toString(Double.parseDouble(op1) + Double.parseDouble(op2));
            default:
                return Double.toString(Double.parseDouble(op2) - Double.parseDouble(op1));
        }
    }
}
