package Bonus;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

import Feuille5.GenerateArray;

public class mergesort {

    public static void main(String[] args) {
        Instant start = Instant.now();
        int size = 5000;
        GenerateArray.generate(size, 500);
        Integer[] list = new Integer[size];
        list = GenerateArray.getList().toArray(list);
        Integer[] sortedList = mergeSort(list);
        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();
        // System.out.println(Arrays.toString(list));
        // System.out.println(Arrays.toString(sortedList));
        System.out.println(timeElapsed + " ms");

    }

    public static Integer[] mergeSort(Integer[] list) {
        int mid = list.length / 2;
        if (list.length < 2) {
            return list;
        }

        Integer[] left = new Integer[mid];
        for (int i = 0; i < mid; i++) {
            left[i] = list[i];
        }
        Integer[] right = new Integer[list.length - mid];

        for (int i = mid; i < list.length; i++) {
            right[i - mid] = list[i];
        }
        Integer[] merged = merge(mergeSort(left), mergeSort(right));
        return merged;
    }

    public static Integer[] merge(Integer[] left, Integer[] right) {
        Integer[] list = new Integer[left.length + right.length];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                list[k] = left[i];
                i++;
            } else {
                list[k] = right[j];
                j++;
            }
            k++;

        }

        while (i < left.length) {
            list[k] = left[i];
            i++;
            k++;
        }
        while (j < right.length) {
            list[k] = right[j];
            j++;
            k++;
        }
        return list;
    }

}
