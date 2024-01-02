class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<HashSet<Integer>> listOfSet = new ArrayList<>();
        HashSet<Integer> set  = new HashSet<>();
        boolean isAdded = false;
        listOfSet.add(set);
        for(int num : nums) {
            isAdded = false;
            for(HashSet s : listOfSet) {
                if(!s.contains(num)) {
                    s.add(num);
                    isAdded = true;
                    break;
                }
            }
            if(!isAdded)
            {
                HashSet<Integer> newSet = new HashSet<>();
                newSet.add(num);
                listOfSet.add(newSet);
                isAdded = false;
            }
        }

        //Convert hash set to array list.
        for(HashSet s : listOfSet) {
            ArrayList<Integer> list = new ArrayList<>(s);
            res.add(list);
        }

        return res;
    }
}