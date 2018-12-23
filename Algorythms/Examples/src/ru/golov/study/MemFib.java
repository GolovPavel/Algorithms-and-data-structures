package ru.golov.study;

public class MemFib {

    private static final int[] CACHE = new int[2048];

    static {
        CACHE[1] = 1;
    }

    public static void main(String[] args) {
        System.out.println(fib(0));
    }

    public static int fib(int n) {
        if (n == 0) {
            return CACHE[0];
        } else if (CACHE[n] != 0) {
            return CACHE[n];
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }
}
