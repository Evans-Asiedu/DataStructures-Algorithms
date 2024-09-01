package com.company;

public class QueueWithTwoStacks {
    private Stack stack1 = new Stack();
    private Stack stack2 = new Stack();

    public void enqueue(int item){
        stack1.push(item);
    }

    public int dequeue(){
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }

        return stack2.pop();
    }
}
