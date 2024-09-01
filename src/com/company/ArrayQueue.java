package com.company;

import java.util.Arrays;
import java.util.Queue;

public class ArrayQueue {
    private int[] items;
    private int front;
    private int rear;
    private int count;

    public ArrayQueue(int capacity){
        items = new int[capacity];
    }

    public void enqueue(int item){
        if(isFull())
            throw new IllegalStateException();

        items[rear++] = item;
        rear %= items.length;
        count++;
    }

    public int dequeue(){
        if(isEmpty())
            throw new IllegalStateException();

        var item = items[front];
        items[front++] = 0;
        front %= items.length;

        count--;
        return item;
    }

    public int peek(){
        return items[front];
    }

    public boolean isEmpty(){
        return count == 0;
    }

    public boolean isFull(){
        return  count == items.length;
    }

    @Override
    public String toString(){
        return Arrays.toString(items);
    }

//    public static void reverse(Queue<Integer> queue){
//        Stack stack = new Stack();
//        while(!queue.isEmpty()){
//            stack.push(queue.remove());
//        }
//
//        while(!stack.isEmpty()){
//            queue.add(stack.pop());
//        }
//    }
}
