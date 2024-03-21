class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int low = 0, mid = 0, high = n-1;
        while(mid <= high) {
            switch(nums[mid]) {
                case 0 : swap(low, mid, nums); 
                        mid++;
                        low++;
                        break;
                case 1 : mid++;
                        break;
                case 2 : swap(mid, high, nums);
                        high--;
                        break;
            }
        }
    }

    private void swap(int x, int y, int[] nums) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}