package ru.golov.study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class QuickSort {
    private static Random random = new Random();

    public static int[] quickSort(int[] arr) {
        if (arr.length < 4) {
            return sortThree(arr);
        }

        int mainElementInx = random.nextInt(arr.length);
        int[] leftArr = quickSort(
                getLeftArr(arr, arr[mainElementInx])
        );
        int[] rightArr = quickSort(
                getRightArr(arr, arr[mainElementInx])
        );

        return combine(leftArr, arr[mainElementInx], rightArr);
    }


    private static int[] sortThree(int[] elems) {
        Arrays.sort(elems);
        return elems;
    }

    private static int[] getLeftArr(int[] arr, int mainElem) {
        List<Integer> left = new ArrayList<>();

        for (int elem : arr) {
            if (elem < mainElem) {
                left.add(elem);
            }
        }

        return left
                .stream()
                .mapToInt(i -> i)
                .toArray();
    }

    private static int[] getRightArr(int[] arr, int mainElem) {
        List<Integer> right = new ArrayList<>();
        boolean isMainSkiped = false;

        for (int elem : arr) {
            if (elem >= mainElem) {
                if (elem == mainElem && !isMainSkiped) {
                    isMainSkiped = true;
                } else {
                    right.add(elem);
                }
            }
        }

        return right
                .stream()
                .mapToInt(i -> i)
                .toArray();
    }

    private static int[] combine(int[] left, int middle, int[] right) {
        int[] newArr = new int[left.length + right.length + 1];
        System.arraycopy(left, 0, newArr, 0, left.length);
        newArr[left.length] = middle;
        System.arraycopy(right, 0, newArr, left.length + 1, right.length);

        return newArr;
    }


    public static void main(String[] args) {
        int[] arr = {2, 6, 3, 2, 7, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2};
        arr = quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
