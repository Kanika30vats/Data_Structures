public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<Integer> repeatedNumber(final List<Integer> arr) {
        long repeating = 0, missing = 0;
        long n = arr.size();
        long s = 0, sn = 0, s2 = 0, s2n = 0;
        sn = (n * (n+1)) / 2;
        s2n = (n * (n+1) * (2*n+1)) / 6;
        for(int i = 0; i < n; i++) {
            s += arr.get(i);
            s2 += (long)arr.get(i) * (long)arr.get(i);
        }
        long val1 = s - sn;
        long val2 = s2 - s2n;
        val2 = val2/val1;
        repeating = (val1 + val2) / 2;
        missing = repeating - val1;
        ArrayList<Integer> list = new ArrayList<>();
        list.add((int)repeating);
        list.add((int)missing);
        return list;
    }
}
