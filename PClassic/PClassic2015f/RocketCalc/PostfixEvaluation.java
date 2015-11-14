import java.util.*;
import java.io.File;
import java.io.IOException;

public class PostfixEvaluation{

    public static void main(String[] args) throws IOException {
        String expression = "";
        Scanner in = new Scanner(new File("PostfixEvaluationIN.txt"));
        while(in.hasNext()){
            expression = in.nextLine();
            System.out.printf("%.1f\n", solve(expression));
        }
    }

    public static double solve (String expression){
        Stack<Double> stack = new Stack<Double>();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            double value;
            switch(c) {
                case '+':
                    value = stack.pop().doubleValue();
                    stack.push(stack.pop().doubleValue() + value);
                    break;
                case '-':
                    value = stack.pop().doubleValue();
                    stack.push(stack.pop().doubleValue() - value);
                    break;
                case '*':
                    value = stack.pop().doubleValue();
                    stack.push(stack.pop().doubleValue() * value);
                    break;
                case '/':
                    value = stack.pop().doubleValue();
                    stack.push(stack.pop().doubleValue() / value);
                    break;
                default:
                    stack.push((double)Character.getNumericValue(c));
            }
        }
        return (double)stack.pop();
    }
}
