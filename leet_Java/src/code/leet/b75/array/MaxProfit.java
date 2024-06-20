package code.leet.b75.array;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * Dynamic programming
 */
public class MaxProfit {
    int solveBetter(int[] prices) {
        int maxProfit = 0;
        int lowestBuyingPrice = Integer.MAX_VALUE;
        for(int i = 0; i < prices.length; i++) {
            if(prices[i] < lowestBuyingPrice) {
                lowestBuyingPrice = prices[i];
            }
            if(prices[i]>lowestBuyingPrice) {
                if(prices[i]-lowestBuyingPrice > maxProfit) {
                    maxProfit = prices[i]-lowestBuyingPrice;
                }
            }
        }
        return maxProfit;
    }
}
