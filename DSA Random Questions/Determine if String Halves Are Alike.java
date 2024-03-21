class Solution {
    public boolean halvesAreAlike(String s) {
        int mid = s.length()/2;
        String subString1 = s.substring(0, mid);
        String subString2 = s.substring(mid);
        return countVowels(subString1) == countVowels(subString2);
    }

    private int countVowels(String s) {
        int count = 0;
        s = s.toLowerCase();
        for(char c : s.toCharArray()) {
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c =='u') {
                count++;
            }
        }
        return count;
    }
}