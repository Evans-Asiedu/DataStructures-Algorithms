package com.company;

public class MinStack {
    private Stack stack = new Stack();
    private Stack minStack = new Stack();

    public void push(int item){

        if(minStack.isEmpty() || item < minStack.peek()){
            minStack.push(item);
        }

        stack.push(item);
    }

    public int pop(){
        var top = stack.pop();

        if(top == minStack.peek()){
            minStack.pop();
        }

        return top;
    }


    public int min(){
        return minStack.peek();
    }
}
