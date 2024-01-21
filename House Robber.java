class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1)
            return nums[0];

        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return computeMaxAmount(nums, 0, dp);
    }

    private int computeMaxAmount(int[] nums, int i, int[] dp) {
        int n = nums.length;
        if(i >= n)
            return 0;

        if(dp[i] != -1)
            return dp[i];
        
        int take = nums[i] + computeMaxAmount(nums, i+2, dp);
        int notTake = computeMaxAmount(nums, i+1, dp);
        dp[i] = Math.max(take, notTake);
        return dp[i];
    }
}