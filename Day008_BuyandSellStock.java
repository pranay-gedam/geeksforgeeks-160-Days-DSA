package gfg160Days_DSA;

public class Day008_BuyandSellStock {   // only one transaction allowed.

    public static int buyAndSellStocks(int[] prices){
        int buyPrices = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i = 0; i <prices.length ; i++) {
            if (buyPrices < prices[i]) {    // profit
                int profit = prices[i] - buyPrices;     // today's profit
                maxProfit = Math.max(maxProfit, profit);
            } else {
                buyPrices = prices[i];
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int [] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(buyAndSellStocks(prices));
    }
}
