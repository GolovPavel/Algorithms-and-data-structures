package ru.golov.study;

import java.util.*;
import java.util.stream.Collectors;

public class DifferentSummands {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Integer> numbers = new ArrayList<>();
        int count = 1;

        while (n > 0) {
            n -= count;
            if (!numbers.contains(n) && n != count) {
                numbers.add(count);
                count++;
            } else {
                n += count;
                count++;
            }
        }

        System.out.println(numbers.size());
        System.out.println(numbers
                .stream()
                .map(Object::toString)
                .collect(Collectors.joining(" "))
        );
    }
}
