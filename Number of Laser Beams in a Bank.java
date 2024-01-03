class Solution {
    public int numberOfBeams(String[] bank) {
        int res = 0;
        int row1Count = 0;
        for(String s : bank) {
            /**
             * s.replaceAll("0", "") is same as s.replaceAll("[^1]", "")
             * [^1] means that every other character except 1 would get replaced by empty string. 
             */
            int row2Count = s.replaceAll("0", "").length();
            if(row2Count != 0) {
                res += (row1Count * row2Count);
                row1Count = row2Count;
            }
        }
        return res;
    }
}