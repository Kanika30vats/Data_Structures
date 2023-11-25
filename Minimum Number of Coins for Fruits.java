class Solution {
    public int minimumCoins(int[] prices) {
        int n = prices.length;
        int dp[][] = new int[n+1][n+1];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return computeMinCoins(0, 0, prices, dp);
    }
    
    private int computeMinCoins(int ind, int threshold, int[] prices, int dp[][]) {
        if(ind + threshold >= prices.length)
            return 0;
        
        if(dp[ind][threshold] != -1)
            return dp[ind][threshold];
        
        int res = prices[ind] + computeMinCoins(ind + 1, ind + 1, prices, dp);
        
        if(threshold > 0) {
            res = Math.min(res, computeMinCoins(ind + 1, threshold - 1, prices, dp));
        }
        
        dp[ind][threshold] = res;
        return dp[ind][threshold];
    }
}