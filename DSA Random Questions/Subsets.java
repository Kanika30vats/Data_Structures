class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        generateSubsets(nums, res, new ArrayList<>(), 0);
        return res;
    }

    private void generateSubsets(int[] nums, List<List<Integer>> res, ArrayList<Integer> tempAns, int index) {
        if(index == nums.length)
            res.add(new ArrayList<>(tempAns));
        else {
            // not take
            generateSubsets(nums, res, tempAns, index+1);

            // take
            tempAns.add(nums[index]);
            generateSubsets(nums, res, tempAns, index + 1);
            tempAns.remove(tempAns.size() - 1);
        }
    }
}