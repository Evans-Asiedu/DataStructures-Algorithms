package com.company;

public class MaxHeap {
    public static void heapify(int[] array){
        var lastParentIndex = array.length / 2 - 1;
        for(int i = 0; i < lastParentIndex; i++){ // no need to iterate to the leaf node cos they have no children
            var leftIndex = (i * 2) + 1;
            if(leftIndex > array.length - 1)
                leftIndex = i;

            var rightIndex = (i * 2) + 2;
            if(rightIndex > array.length - 1)
                rightIndex = i;

            if(!isValidParent(array, i, leftIndex, rightIndex)){
                if(array[leftIndex] > array[rightIndex]){
                    swap(array, i, leftIndex);
                }
                else{
                    swap(array, i, rightIndex);
                }
            }
        }
    }

    public static int getKthLargest(int[] array, int k){
        if(k < 1 || k > array.length)
            throw new IllegalStateException();

        var heap = new Heap();
        for(var number : array){
            heap.insert(number);
        }

        for(int i = 1; i < k; i++)
            heap.remove();

        return heap.remove();
    }

    private static boolean isValidParent(int[] array, int currentIndex,
                                         int leftIndex, int rightIndex){
        return array[currentIndex] >= array[leftIndex] &&
                array[currentIndex] >= array[rightIndex];
    }
    private static void swap(int[] array, int first, int second){
        var temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }

}
