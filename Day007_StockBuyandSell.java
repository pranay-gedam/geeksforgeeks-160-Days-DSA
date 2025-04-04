package gfg160Days_DSA;

public class Day007_StockBuyandSell {   // multiple transaction allowed
        public static int maximumProfit(int prices[]) {
            int maxProfit = 0;

            for (int i = 1; i < prices.length; i++) {
                // If the current price is greater than the previous day's price,
                // we can make a profit by selling today after buying yesterday.
                if (prices[i] > prices[i - 1]) {
                    maxProfit += (prices[i] - prices[i - 1]);
                }
            }
            return maxProfit;
        }

    public static void main(String[] args) {
        int [] prices = {100, 180, 260, 310, 40, 535, 695};
        System.out.println(maximumProfit(prices));
    }
}
