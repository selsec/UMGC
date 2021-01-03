/* CMSC 350 Data Structures and Analysis
 * Project 1
 * Author: Steven Thaw
 * Date: 05/29/20
 * This class will receive the input, tokenize it, and convert it to/from prefix and postfix
 */


import java.util.*;

public class Evaluator {
    //create stack variables for the operands and operators
    private Stack<String> operandStack = new Stack<>();
    private Stack<String> reversalStack = new Stack<>();

    //method to take user input, tokenize it, and convert it to postfix notation
    public String preToPost(String userInput) {
        String operandPop = "";
        String temp = "";
        //Array list to use as token placeholder
        List<String> tokenizer = new ArrayList<>();
        //add the first character to prevent errors when comparing next and last
        tokenizer.add(Character.toString(userInput.charAt(0)));
        //iterate through arraylist and evaluate user input, skip spaces, and combine digits if more than 0-9
        for (int i = 1; i < userInput.length(); i++) {
            char next = userInput.charAt(i);
            char last = userInput.charAt(i - 1);
            //check if next char is a space, skip if it is
            if (Character.isWhitespace(next)) {
                continue;
            }
            //check if next and last are digits, if so, combine and add to list
            if (Character.isDigit(next) && Character.isDigit(last)) {
                int lastIndex = (tokenizer.size() - 1);
                tokenizer.set(lastIndex, tokenizer.get(lastIndex) + next);
            }
            else { // Adds token like normal
                tokenizer.add(Character.toString(next));
                }
            }
        //push list to stack
        for (int i = 0; i < tokenizer.size(); i++) {
            reversalStack.push(tokenizer.get(i));
        }
        //evaluate stack and place in proper order
        try {
            while (!reversalStack.isEmpty()) {
                temp = reversalStack.pop();
                if (!temp.contains("+") && !temp.contains("-") && !temp.contains("*") && !temp.contains("/")) {
                    operandStack.push(temp);
                } else {
                    operandPop += operandStack.pop() + " " + operandStack.pop() + " " + temp + " ";
                }
            }
        } catch (Exception ex) {
            SyntaxError.message();
        }
        System.out.println(operandPop);
        return operandPop;
    }

    //method to take user input, tokenize it, and convert it to prefix notation
    public String postToPre(String userInput) {
        String operandPop = "";
        //Array list to use as token placeholder
        List<String> tokenizer = new ArrayList<>();
        //add the first character to prevent errors when comparing next and last
        tokenizer.add(Character.toString(userInput.charAt(0)));
        //iterate through arraylist and evaluate user input, skip spaces, and combine digits if more than 0-9
        for (int i = 1; i < userInput.length(); i++) {
            char next = userInput.charAt(i);
            char last = userInput.charAt(i - 1);
            //check if next char is a space, skip if it is
            if (Character.isWhitespace(next)) {
                continue;
            }
            //check if next and last are digits, if so, combine and add to list
            if (Character.isDigit(next) && Character.isDigit(last)) {
                int lastIndex = (tokenizer.size() - 1);
                tokenizer.set(lastIndex, tokenizer.get(lastIndex) + next);
            }
            else { // Adds token like normal
                tokenizer.add(Character.toString(next));
            }
        }
        //push list to stack
        for (int i = 0; i < tokenizer.size(); i++) {
            reversalStack.push(tokenizer.get(i));
        }
        //test statement System.out.println(reversalStack.size());
        try {
            String temp = "";
            String holder = "";
            while (!reversalStack.isEmpty()) {
                temp = reversalStack.pop();
                System.out.println(temp);
                if (temp.contains("-") || temp.contains("+") || temp.contains("*") || temp.contains("/")) {
                    operandStack.push(temp);
                    System.out.println(operandStack.peek());
                } else {
                    holder += temp + " ";
                }
            }
            while (!operandStack.isEmpty()) {
                operandPop += operandStack.pop() + " ";
            }
            operandPop += holder;
            } catch (Exception ex) {
            SyntaxError.message();
        }
        //test statement System.out.println(operandPop);
        return operandPop;
    }
}

