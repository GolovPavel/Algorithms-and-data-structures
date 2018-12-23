package ru.golov.study;

import java.util.Arrays;
import java.util.List;

public class BestPrice {


    public static void main(String[] args) {
        List<Integer> prices = Arrays.asList(12, 10, 2, 15, 16, 1, 2);
        System.out.println(Arrays.toString(getBestPrice(prices)));
    }

    public static int[] getBestPrice(List<Integer> prices) {
        int[] B = new int[prices.size()];
        int bestSaleDay = 0;
        int bestProfit = 0;

        for (int i = 1; i < prices.size(); i++) {
            int currentPrice = prices.get(i);

            if (currentPrice < prices.get(B[i - 1])) {
                B[i] = i;
            } else {
                B[i] = B[i - 1];
            }

            int profit = currentPrice - B[i];

            if (profit > bestProfit) {
                bestProfit = profit;
                bestSaleDay = i;
            }
        }

        return new int[] {
                B[bestSaleDay],
                bestSaleDay,
        };
    }
}
