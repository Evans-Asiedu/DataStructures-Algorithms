package com.company;

import java.util.Arrays;

public class TwoStacks {
    private int[] items = new int[5];
    private int leftCount;
    private int rightCount = items.length;

    public void push1(int item){
        if(isFull1())
            throw new IllegalStateException();
        items[leftCount++] = item;
    }

    public int pop1(){
        if(isEmpty1())
            throw new IllegalStateException();
        return items[--leftCount];
    }

    public boolean isFull1(){
        return (rightCount <= leftCount);
    }

    public boolean isEmpty1(){
        return leftCount == 0;
    }


    public void push2(int item){
        if(isFull2())
            throw new IllegalStateException();
        items[--rightCount] = item;
    }

    public int pop2(){
        if(isEmpty2())
            throw new IllegalStateException();
        return items[rightCount++];
    }

    public boolean isFull2(){
        return (rightCount <= leftCount);
    }



    public boolean isEmpty2(){
        return rightCount == items.length;
    }

    @Override
    public String toString(){
        return Arrays.toString(items);
    }


}
