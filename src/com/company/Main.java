package com.company;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] numbers = { 7, 4, 1, 5, 8, 2 };
        int[] num = {1, 3, 5, 6, 7, 9};

        var search = new Search();
        var index = search.exponentialSearch(num, 7);
        System.out.println(index);

        System.out.println("done");
    }

}
