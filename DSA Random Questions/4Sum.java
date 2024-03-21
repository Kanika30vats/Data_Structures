/**
 * Using HashSet. Better Approach.
 * TC : O(n^3)
 */
// class Solution {
//     public List<List<Integer>> fourSum(int[] nums, int target) {
//         int n = nums.length;
//         HashSet<ArrayList<Integer>> res = new HashSet<>();
//         for(int i=0;i<n;i++) {
//             for(int j=i+1;j<n;j++) {
//                 HashSet<Long> tempSet = new HashSet<>();
//                 for(int k=j+1;k<n;k++) {
//                     long sum = 0;
//                     sum += nums[i];
//                     sum += nums[j];
//                     sum += nums[k];
                    
//                     long forthElement = target - (sum);
//                     if(tempSet.contains(forthElement)) {
//                         ArrayList<Integer> list = new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k], (int)forthElement));
//                         Collections.sort(list);
//                         res.add(list);
//                     }
//                     else {
//                         tempSet.add((long)nums[k]);
//                     }
//                 }
//             }
//         }
//         List<List<Integer>> ans = new ArrayList<>(res);
//         return ans;
//     }
// }

/**
 * Using 2 pointer approach. Optimal Approach.
 * TC : O(n^3)
 */
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<n;i++) {
            if(i > 0 && nums[i] == nums[i-1])
                continue;
            for(int j=i+1;j<n;j++) {
                if(j > i+1 && nums[j] == nums[j-1])
                    continue;
                int low = j+1;
                int high = n-1;
                while(low<high) {
                    long sum = 0;
                    sum += nums[i];
                    sum += nums[j];
                    sum += nums[low];
                    sum += nums[high];
                    if(sum == target) {
                        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(nums[i],nums[j],nums[low],nums[high]));
                        res.add(list);
                        low++;
                        high--;

                        while(low<high && nums[low] == nums[low-1])
                            low++;
                        while(low<high && nums[high] == nums[high+1])
                            high--;
                    }
                    else if(sum < target) {
                        low++;
                    }
                    else {
                        high--;
                    }
                }
            }
        }
        return res;
    }
}