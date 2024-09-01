package com.company;

import java.util.Arrays;

public class Stack {
    private int[] items = new int[10];
    private int count;

    public void push(int item){
        if(isFull())
            throw new StackOverflowError();

        items[count++] = item;
    }

    public int pop(){
        if(isEmpty())
            throw new IllegalStateException();

        return items[--count];
    }

    public int peek(){
        if(isEmpty())
            throw new IllegalStateException();

        return items[count - 1];
    }


    public boolean isEmpty(){
        return count == 0;
    }

    private boolean isFull(){
        return count == items.length;
    }

//    private void resize(){
//        int[] newItems = new int[count * 2];
//
//        for(int i = 0; i < count; i++)
//            newItems[i] = items[i];
//
//        items = newItems;
//    }

    @Override
    public String toString(){
       var result = Arrays.copyOfRange(items, 0, count);
       return Arrays.toString(result);
    }
}
