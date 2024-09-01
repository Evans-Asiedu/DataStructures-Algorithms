package com.company;

import java.util.NoSuchElementException;

public class LinkedList {
    private class Node {
        private int value;
        private Node next;

        public Node(int value){
            this.value = value;
        }
    }

    private Node first;
    private Node last;
    private int size;

    public void addLast(int item){
        var node = new Node(item);

        if(isEmpty()){
            first = last = node;
        }
        else{
            last.next = node;
            last = node;
        }

        size++;
    }

    public void addFirst(int item){
        var node = new Node(item);

        if(isEmpty()){
            first = last = node;
        }
        else{
            node.next = first;
            first = node;
        }

        size++;
    }

    public int indexOf(int item){
        var current = first;
        int index = 0;

        while(current != null){
            if(current.value == item)
                return index;
            current = current.next;
            index++;
        }

        return -1;
    }

    public boolean contains(int item){
        return indexOf(item) != -1;
    }

    public void removeFirst(){
        if(isEmpty())
            throw new NoSuchElementException();

        if(first == last){
            first = last = null;
        }
        else{
            var temp = first.next;
            first.next = null;
            first = temp;
        }

        size--;
    }

    public void removeLast(){
        if(isEmpty())
            throw new NoSuchElementException();

        if(first == last){
            first = last = null;
        }
        else{
            var previous = getPrevious(last);
            last = previous;
            last.next = null;
        }

        size--;
    }

    public int size(){
        return size;
    }

    private Node getPrevious(Node node){
        var current = first;
        while(current.next != node){
            current = current.next;
        }
        return current;
    }

    public int[] toArray(){
        int[] array = new int[size];
        var current = first;
        var index = 0;
        while(current != null){
            array[index++] = current.value;
            current = current.next;
        }

        return array;
    }

    public void reverse(){
        if(isEmpty()) return;

        var previous = first;
        var current = first.next;

        while(current != null){
            var next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        last = first;
        first = previous;
        last.next = null;
    }

    public int getKthNodeFromEnd(int k){
        if(isEmpty())
            throw new IllegalStateException();

        var a = first;
        var b = first;

        for(int i = 0; i < (k - 1); i++) {
            b = b.next;
            if(b == null)
                throw new IllegalArgumentException();
        }

        while(b != last){
            a = a.next;
            b = b.next;
        }

        return a.value;
    }

    public void printMiddle(){
        var a = first;
        var b = first;

        while(b != last && b.next != last){
            b = b.next.next;
            System.out.println(b.value);
            a = a.next;
        }

        if(b == last)
            System.out.println(a.value);
        else
            System.out.println(a.value + ", " + a.next.value);
    }

    public boolean hasLoop(){
        var slow = first;
        var fast = first;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(fast == slow)
                return true;
        }

        return false;
    }

    private boolean isEmpty(){
        return first == null;
    }
}
