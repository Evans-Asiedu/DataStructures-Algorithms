package com.company;

import java.util.Arrays;

public class PriorityQueue {
    private int[] items = new int[5];
    private int count;

    public void add(int item){
        if(isFull())
            throw new IllegalStateException();

        int i;
        for(i = count - 1; i >= 0; i--){
            if(item < items[i]){
                items[i + 1] = items[i];
            }
            else{
                break;
            }
//            if(item > items[i]){
//                items[i + 1] = item;
//                count++;
//                return;
//            }
//            items[i + 1] = items[i];
        }

        items[i + 1] = item;
        count++;
    }

    public int remove(){
        if(isEmpty())
            throw new IllegalStateException();
        
        var item = items[0];
        for(int i = 0; i < count - 1; i++){
            items[i] = items[i + 1];
        }
        items[--count] = 0;
        return item;
    }

    private boolean isEmpty(){
        return count == 0;
    }

    private boolean isFull(){
        return count == items.length;
    }

    @Override
    public String toString(){
        return Arrays.toString(items);
    }


}
