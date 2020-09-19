package com.example;

import java.util.Stack;

public class BalancedBrackets {

    public boolean isBalanced(String expression) {

        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < expression.length(); i++) {

            char ch = expression.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }

            if (stack.empty()) {
                return false;
            }

            if (ch == ')' && stack.pop() != '(') {
                return false;
            }

            if (ch == '}' && stack.pop() != '{') {
                return false;
            }

            if (ch == ']' && stack.pop() != '[') {
                return false;
            }
        }

        return stack.empty();
    }
}
