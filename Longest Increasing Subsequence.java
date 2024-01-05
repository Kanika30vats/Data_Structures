class Solution {
    public int lengthOfLIS(int[] nums) {
        int res = 1;
        ArrayList<Integer> list = new ArrayList<>();
        list.add(nums[0]);

        for(int i = 1; i < nums.length; i++) {
            if(nums[i] > list.get(list.size() - 1)) {
                list.add(nums[i]);
                res++;
            }
            else {
                int ceilIndex = findCeilingIndex(list, nums[i], 0, list.size()-1);
                list.set(ceilIndex, nums[i]);
            }
        }
        return res;
    }

    private int findCeilingIndex(ArrayList<Integer> list, int num, int low, int high) {
        while(low < high) {
            int mid = low + (high-low)/2;
            if(num <= list.get(mid))
                high = mid;
            else if(num > list.get(mid))
                low = mid + 1;
        }
        return high;
    }
}