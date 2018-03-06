package ru.golov.study;

import javafx.util.Pair;

import java.util.*;
import java.util.stream.Collectors;

public class LinesAndDots {
    public static void main(String[] args) {
        TreeSet<Pair<Long, Long>> pairs = new TreeSet<>((o1, o2) -> {
            int result = 0;
            result += Long.compare(o1.getValue(), o2.getValue());
            if (result == 0) {
                result += Long.compare(o1.getKey(), o2.getKey());
            }

            return result;
        });
        List<Long> points = new ArrayList<>();

	    Scanner sc = new Scanner(System.in);
	    int countOfLines = sc.nextInt();

	    for (int i = 0; i < countOfLines; i++) {
	        long coord1 = sc.nextLong();
	        long coord2 = sc.nextLong();

            Pair<Long, Long> coords = new Pair<>(coord1, coord2);
            pairs.add(coords);
        }

        while (!pairs.isEmpty()) {
            Pair<Long, Long> pair = pairs.pollFirst();
            long point = pair.getValue();
            points.add(point);

            while (!pairs.isEmpty()) {
                pair = pairs.first();

                if (pair.getKey() <= point && pair.getValue() >= point) {
                    pairs.pollFirst();
                } else {
                    break;
                }
            }
        }

        System.out.println(points.size());
        String joinPoints = points.stream()
                .map(Object::toString)
                .collect(Collectors.joining(" "));
        System.out.println(joinPoints);
    }
}
