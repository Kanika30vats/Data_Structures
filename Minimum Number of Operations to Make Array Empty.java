class Solution {
    public int minOperations(int[] nums) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        int res = 0, rem = 0;
        for(int num : nums) 
        {
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }

        for(HashMap.Entry<Integer,Integer> mapEntry : hashMap.entrySet())
        {
            int n = mapEntry.getValue();
            if(n == 1)
                return -1;
            res += n/3;
            if(n % 3 != 0)
                res++;
        }
        return res;
    }
}