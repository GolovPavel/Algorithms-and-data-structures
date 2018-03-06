package ru.golov.study;

import javafx.util.Pair;

import java.util.*;

public class Backpack {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int countOfItems = sc.nextInt();
        int capacity = sc.nextInt();
        double resultCoast = 0;

        List<Pair<Integer, Integer>> items = getSortedItems(countOfItems);

        while (capacity > 0 && !items.isEmpty()) {
            Pair<Integer, Integer> pair = items.get(0);

            if (pair.getValue() < capacity) {
                resultCoast += pair.getKey();
                capacity -= pair.getValue();
                items.remove(0);
            } else {
                double costOfPart = 1.0 * pair.getKey() / pair.getValue() * capacity;
                resultCoast += costOfPart;
                capacity = 0;
            }
        }

        System.out.println(resultCoast);
    }

    private static List<Pair<Integer, Integer>> getSortedItems(int countOfItems) {
        List<Pair<Integer, Integer>> items = new LinkedList<>();

        for (int i = 0; i < countOfItems; i++) {
            int coast = sc.nextInt();
            int volume = sc.nextInt();
            Pair<Integer, Integer> pair = new Pair<>(coast, volume);
            items.add(pair);
        }

        items.sort((o1, o2) ->
            Double.compare(1.0 * o2.getKey() / o2.getValue(), 1.0 * o1.getKey() / o1.getValue())
        );

        return items;
    }
}
