package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class BalancedExpression {

    public boolean isBalanced(String input){
        if(input == null)
            throw new IllegalArgumentException();

        var openBrackets = Arrays.asList('(', '[',  '<', '{');
        var closeBrackets = Arrays.asList(')', ']',  '>', '}');

        Stack<Character> stack = new Stack<>();
        for(char ch: input.toCharArray()){
            if(openBrackets.contains(ch)){
                stack.push(ch);
            }

            if(closeBrackets.contains(ch)){
                if(stack.isEmpty())
                    return false;

                var top = stack.pop();
                if(openBrackets.indexOf(top) != closeBrackets.indexOf(ch))
                    return false;
            }
        }

        return stack.isEmpty();
    }
}

// #A new class needs to be created for this function classed StringReverse
//    public static String reverse(String str){
//        if(str == null)
//            throw new IllegalArgumentException();
//
//        Stack<Character> stack = new Stack<>();
//        for(char ch: str.toCharArray()){
//            stack.push(ch);
//        }
//
//        StringBuffer reversed = new StringBuffer();
//        while(!stack.isEmpty()){
//            reversed.append(stack.pop());
//        }
//
//        return reversed.toString();
//    }
