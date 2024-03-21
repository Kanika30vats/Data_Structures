class Solution {
    public List<Integer> majorityElement(int[] nums) {
        // Using Boyer Moore Voting Algo
        ArrayList<Integer> res = new ArrayList<>();
        int c1=0,c2=0,m1=-1,m2=-2;
        int threshold = nums.length/3;
        for(int i=0;i<nums.length;i++) {
            if(m1 == nums[i])
                c1++;
            else if(m2 == nums[i])
                c2++;
            else if(c1 == 0){
                m1 = nums[i];
                c1++;
            }
            else if(c2 == 0) {
                m2 = nums[i];
                c2++;
            }
            else {
                c1--;
                c2--;
            }
        }

        // To check whether m1 and m2 are majority elements.
        c1 = 0;
        c2 = 0;
        for(int i=0;i<nums.length;i++) {
            if(nums[i] == m1)   c1++;
            if(nums[i] == m2)   c2++;
        }
        if(c1 > threshold)  res.add(m1);
        if(c2 > threshold)  res.add(m2);
        return res;
    }
}