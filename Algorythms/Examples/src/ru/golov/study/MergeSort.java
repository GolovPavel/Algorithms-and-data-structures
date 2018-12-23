package ru.golov.study;

import java.util.Arrays;

public class MergeSort {
    private int[] merge(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        int aIndex = 0;
        int bIndex = 0;

        while (aIndex != a.length || bIndex != b.length) {
            if (aIndex == a.length) {
                System.arraycopy(b, bIndex, result, aIndex + bIndex, b.length - bIndex);
                bIndex = b.length;
            } else if (bIndex == b.length) {
                System.arraycopy(a, aIndex, result, aIndex + bIndex, a.length - aIndex);
                aIndex = a.length;
            } else {
                if (a[aIndex] < b[bIndex]) {
                    result[aIndex + bIndex] = a[aIndex];
                    aIndex++;
                } else {
                    result[aIndex + bIndex] = b[bIndex];
                    bIndex++;
                }
            }
        }

        return result;
    }

    public int[] sort(int[] arr) {
        if (arr.length == 1) {
            return arr;
        }

        int[] left = Arrays.copyOfRange(arr, 0, arr.length / 2);
        int[] right = Arrays.copyOfRange(arr, arr.length / 2, arr.length);

        return merge(sort(left), sort(right));
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 8, 3, 6, 10, 23, 4};

        MergeSort mergeSort = new MergeSort();
        arr = mergeSort.sort(arr);
        System.out.println(Arrays.toString(mergeSort.sort(arr)));
    }
}
