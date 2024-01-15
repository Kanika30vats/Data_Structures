class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        HashSet<Integer> set = new HashSet<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();

        for(int i = 0; i < matches.length; i++) {
                set.add(matches[i][0]);
                map.put(matches[i][1], map.getOrDefault(matches[i][1], 0) + 1);
        }

        Iterator<Integer> setIterator = set.iterator();
        while(setIterator.hasNext()) {
            Integer next = setIterator.next();
            if(!map.containsKey(next)) {
                list1.add(next);
            }
        }

        for(Map.Entry<Integer, Integer> entrySet : map.entrySet()) {
            if(entrySet.getValue() == 1) {
                list2.add(entrySet.getKey());
            }
        }

        Collections.sort(list1);
        Collections.sort(list2);

        res.add(list1);
        res.add(list2);

        return res;
    }
}