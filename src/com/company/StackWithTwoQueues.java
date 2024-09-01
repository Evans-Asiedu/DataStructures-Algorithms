package com.company;

import java.util.ArrayDeque;
import java.util.Queue;

public class StackWithTwoQueues {
    Queue<Integer> queue1 = new ArrayDeque<>();
    Queue<Integer> queue2 = new ArrayDeque<>();

    public void push(int item){
        if(!queue1.isEmpty())
            queue1.add(item);
        else
            queue2.add(item);
    }

    public int pop(){
        if(isEmpty())
            throw new IllegalStateException();

        int top;
        int size;
        if(queue1.isEmpty()){
            size = queue2.size();
            for(int i = 1; i < size; i++)
                queue1.add(queue2.remove());
             top = queue2.remove();
        }
        else{
            size = queue1.size();
            for(int i = 1; i < size; i++)
                queue2.add(queue1.remove());
            top = queue1.remove();
        }

        return top;
    }

    public int peek(){
        if(isEmpty())
            throw new IllegalStateException();

        int top = pop();
        if(!queue1.isEmpty())
            queue1.add(top);
        else
            queue2.add(top);
        return top;
    }

    public boolean isEmpty(){
        return (queue1.size() == 0 && queue2.size() == 0);
    }

    public int size(){
        int size;
        if(!queue1.isEmpty())
             size = queue1.size();
        else{
            size = queue2.size();
        }
        return size;
    }

    public void ToString(){
        if(!queue1.isEmpty()) {
            System.out.println(queue1);
        }
        else{
            System.out.println(queue2);
        }
    }
}
