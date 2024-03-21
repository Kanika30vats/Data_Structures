class Solution {
    public int maxLength(List<String> arr) {
        return computeMaxLength(arr, 0, "");
    }

    private int computeMaxLength(List<String> arr, int i, String str) {
        if(i >= arr.size())
            return str.length();

        int include = 0;
        if(!hasDuplicates(arr.get(i), str))
            include = computeMaxLength(arr, i+1, str.concat(arr.get(i)));
        int exclude = computeMaxLength(arr, i+1, str);

        return Math.max(include, exclude);
    }

    private boolean hasDuplicates(String s1, String s2) {
        int[] flag = new int[26];
        for(char c : s1.toCharArray()) {
            if(flag[c - 'a'] != 0)
                return true;
            flag[c - 'a']++;
        }

        for(char c : s2.toCharArray()) {
            if(flag[c - 'a'] != 0)
                return true;
        }
        return false;
    }
}