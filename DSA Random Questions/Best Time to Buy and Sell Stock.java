class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int currProfit = 0;
        int minElement = prices[0];
        for(int i = 1; i < prices.length; i++) {
            currProfit = prices[i] - minElement;
            profit = Math.max(currProfit, profit);
            minElement = Math.min(prices[i], minElement);
        }
        return profit;
    }
}