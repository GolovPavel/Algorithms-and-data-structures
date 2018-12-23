package ru.golov.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BinarySearch {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String s1 = reader.readLine();
        String s2 = reader.readLine();

        reader.close();

        String[] splited1 = s1.split(" ");
        String[] splited2 = s2.split(" ");

        int[] arr = new int[Integer.valueOf(splited1[0])];
        int[] keys = new int[Integer.valueOf(splited2[0])];


        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.valueOf(splited1[i + 1]);
        }

        for (int i = 0; i < keys.length; i++) {
            keys[i] = Integer.valueOf(splited2[i + 1]);
        }

        for (int i = 0; i < keys.length; i++) {
            System.out.print(binarySearch(arr, keys[i]) + " ");
        }
    }

    public static int binarySearch(int[] arr, int elem) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int middle = (left + right) / 2;
            if (arr[middle] == elem) {
                return middle + 1;
            } else if (arr[middle] < elem) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        return -1;
    }
}
