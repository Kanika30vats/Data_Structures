class Solution {
    public int[] findErrorNums(int[] nums) {
        int duplicate = 0;
        int missing = 0;

        // Loop to find duplicate element.
        for(int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if(nums[index] < 0)
                duplicate = index + 1;
            else
                nums[index] = nums[index] * -1;
        }

        // Loop to find missing element.
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                missing = i + 1;
                break;
            }
        }

        return new int[] {duplicate, missing};
    }
}