class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for(int row = 0; row < numRows; row++) {
            ArrayList<Integer> currList = new ArrayList<>();
            for(int col = 0; col <= row; col++) {
                if(col == 0 || col == row)
                    currList.add(1);
                else
                    currList.add(res.get(row-1).get(col-1) + res.get(row-1).get(col));
            }
            res.add(currList);
        }
        return res;
    }
}