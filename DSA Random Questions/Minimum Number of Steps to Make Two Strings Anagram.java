class Solution {
    public int minSteps(String s, String t) {
        int count[] = new int[26];
        int res = 0;

        for(char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        for(char c : t.toCharArray()) {
            count[c - 'a']--;
        }

        for(int i = 0; i < 26; i++) {
            res += Math.abs(count[i]);
        }

        return res/2;
    }
}