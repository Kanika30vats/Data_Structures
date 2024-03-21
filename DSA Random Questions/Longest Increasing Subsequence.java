class Solution {
    public int lengthOfLIS(int[] nums) {
        int len = 0;
        ArrayList<Integer> countOfLIS = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            if(i == 0 || nums[i] > countOfLIS.get(len-1)) {
                countOfLIS.add(nums[i]);
                len++;
            }
            else {
                int ceilIndex = findCeilIndex(countOfLIS, nums[i], 0, len-1);
                countOfLIS.set(ceilIndex, nums[i]);
            }
        }
        return len;
    }

    private int findCeilIndex(ArrayList<Integer> countOfLIS, int n, int low, int high) {
        while(low < high) {
            int mid = low + (high - low)/2;
            if(countOfLIS.get(mid) >= n) {
                high = mid;
            }
            else {
                low = mid + 1;
            }
        }
        return high;
    }
}