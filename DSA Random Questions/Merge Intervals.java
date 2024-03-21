class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        ArrayList<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
        int currInterval[] = intervals[0];
        for(int i=1;i<n;i++) {
            if(currInterval[1] >= intervals[i][0])
                currInterval[1] = Math.max(currInterval[1], intervals[i][1]);
            else
                {
                    res.add(currInterval);
                    currInterval = intervals[i];
                }
        }
        res.add(currInterval);
        return res.toArray(new int[res.size()][]);
    }
}