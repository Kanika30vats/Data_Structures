class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int index = -1;

        // Find breakpoint where a[i] < a[i+1] from right.
        for(int i = n-2; i >= 0; i--) {
            if(nums[i] < nums[i+1]) {
                index = i;
                break;
            }
        }

        // If no breakpoint
        if(index == -1) {
            reverse(0, n-1, nums);
        }
        // If breakpoint, then find nextGreater to its right.
        else {
            findNextGreater(index, n, nums);
        }
    }

    private void findNextGreater(int index, int n, int[] nums) {
        for(int i = n-1; i >= index; i--) {
            if(nums[i] > nums[index]) {
                int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
            }
        }
        reverse(index+1, n-1, nums);
    }

    private void reverse(int x, int y, int[] nums) {
        while(x < y) {
            int temp = nums[x];
            nums[x] = nums[y];
            nums[y] = temp;
            x++;
            y--;
        }
    }
}