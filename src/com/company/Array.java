package com.company;

public class Array  {
    private int[] items;
    private int count;

    public Array(int length){
        items = new int[length];
    }

    public void insert(int item){
        if(isFull())
            items = resize();

        items[count++] = item;
    }

    public void removeAt(int index){
        if(index < 0 || index >= count)
            throw new IllegalArgumentException();

        for(int i = index; i < count; i++)
            items[i] = items[i + 1];

        count--;
    }

    public int indexOf(int item){
        for(int i = 0; i < count; i++)
            if(items[i] == item)
                return i;

        return -1;
    }

    public int max(){
        int maxValue = items[0];
        for(int i = 0; i < count; i++)
            if(items[i] > maxValue)
                maxValue = items[i];

        return maxValue;
    }

    public Array intersect(Array other){
        Array intersectItems = new Array(count);

        for(int i = 0; i < count; i++){
            if(other.indexOf(items[i]) != -1)
                intersectItems.insert(items[i]);
        }

        return intersectItems;
    }

    public void reverse(){
        int[] reversedItems = new int[count];

        for(int i = 0; i < count; i++)
            reversedItems[i] = items[count - (i + 1)];

        items = reversedItems;
    }

    public void insertAt(int item, int index){
        if(index < 0 || index >= count)
            throw new IllegalArgumentException();

        if(isFull())
            items = resize();

        for(int i = count - 1; i >= index; i--){
            items[i + 1] = items[i];
        }
        items[index] = item;

        count++;
    }

    private boolean isFull(){
        return items.length == count;
    }

    private int[] resize(){
        int[] newItems = new int[count * 2];

        for(int i = 0; i < count; i++)
            newItems[i] = items[i];

        return newItems;
    }

    public void print(){
        for(int i = 0; i < count; i++){
            System.out.println(items[i]);
        }
    }
}
