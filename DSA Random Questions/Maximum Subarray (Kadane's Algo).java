class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currSum = nums[0];
        int n = nums.length;
        for(int i=1; i<n; i++){
            currSum = Math.max(nums[i] + currSum, nums[i]);
            maxSum = Math.max(currSum, maxSum);
        }
        return maxSum;
    }
}