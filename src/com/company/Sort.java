package com.company;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Sort {

    // bubble sort
    public void bubbleSort(int[] array){
        boolean isSorted;
        for(var i = 0; i < array.length; i++){
            isSorted = true;
            for(var j = 1; j < array.length - i; j++){
                if(array[j] < array[j - 1]){
                    swap(array, j, j - 1);
                    isSorted = false;
                }
            }
            if(isSorted)
                return;
        }
    }

    // selection sort
    public void selectionSort(int[] array){
        for(var i = 0; i < array.length; i++){
            var minIndex = i  ;
            for(var j = i; j < array.length; j++){
                if(array[j] < array[minIndex])
                    minIndex = j;
            }
            swap(array, minIndex, i);
        }
    }

    private void swap(int[] array, int firstIndex, int secondIndex){
        var temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }

    // insertion sort
    public void insertionSort(int[] array){
        for(var i = 1; i < array.length; i++){
            var current = array[i];
            var j = i - 1;
            while(j >= 0 && array[j] > current){
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = current;
        }
    }

    // merge sort
    public void mergeSort(int[] array){
        if(array.length < 2)
            return;

        var middle = array.length / 2;

        int[] left = new int[middle];
        for(var i = 0; i < middle; i++)
            left[i] = array[i];

        int[] right = new int[array.length - middle];
        for(var i = middle; i < array.length; i++)
            right[i - middle] = array[i];

        // sort each half
        mergeSort(left);
        mergeSort(right);

        // merge the result
        merge(left, right, array);
    }

    private void merge(int[] left, int[] right, int[] result){
        int i = 0, j = 0, k = 0;

        while(i < left.length && j < right.length){
            if(left[i] <= right[j])
                result[k++] = left[i++];
            else
                result[k++] = right[j++];
        }

        while(i < left.length)
            result[k++] = left[i++];

        while(j < right.length)
            result[k++] = right[j++];
    }


    // quick sort
    public void quickSort(int[] array){
        quickSort(array, 0, array.length - 1);
    }

    private void quickSort(int[] array, int start, int end){
        if(start >= end)
            return;

        // partition
        var boundary = partition(array, start, end);

        // sort left
        quickSort(array, start, boundary - 1);

        // sort right
        quickSort(array, boundary + 1, end);

    }

    private int partition(int[] array, int start, int end){
        var pivot = array[end];
        var boundary = start - 1;
        for(var i = start; i <= end; i++){
            if(array[i] <= pivot){
                swap(array, i, ++boundary);
            }
        }

        return boundary;
    }

    // counting sort
    public void countingSort(int[] array, int max){
        int[] counts = new int[max + 1];
        for(var item : array)
            counts[item]++;

        var k = 0;
        for(var i = 0; i < counts.length; i++)
            for(var j = 0; j < counts[i]; j++)
                array[k++] = i;
    }

    // bucket sort
    public void bucketSort(int[] array, int numberOfBuckets){
        var i = 0;
        for(var bucket : createBuckets(array, numberOfBuckets)){
            Collections.sort(bucket);
            for(var item : bucket)
                array[i++] = item;
        }
    }

    private List<List<Integer>> createBuckets(int[] array, int numberOfBuckets){
        List<List<Integer>> buckets = new ArrayList<>();
        for(var i = 0; i < numberOfBuckets; i++)
            buckets.add(new ArrayList<>());

        for(var item : array)
            buckets.get(item / numberOfBuckets).add(item);

        return buckets;
    }

}
