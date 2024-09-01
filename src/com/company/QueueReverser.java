package com.company;


import java.util.Queue;

public class QueueReverser {

    public void reverse(Queue<Integer> queue, int k){
        if(k < 0 || k > queue.size())
            throw new IllegalStateException();

        Stack stack = new Stack();
        int size = queue.size();

        for(int i = 0; i < k; i++)
            stack.push(queue.remove());

        while(!stack.isEmpty())
            queue.add(stack.pop());

        for(int i = 0; i < size - k; i++)
            queue.add(queue.remove());
    }
}
