class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashSet<Integer> setOfValues = new HashSet<>();
        HashSet<Integer> setOfCount = new HashSet<>();

        Arrays.sort(arr);

        int count = 1;
        for(int i = 0; i < arr.length - 1; i++) {
            if(arr[i] == arr[i+1]) {
                count++;
            }
            else {
                setOfValues.add(arr[i]);
                setOfCount.add(count);
                count = 1;
            }
        }
        setOfValues.add(arr[arr.length-1]);
        setOfCount.add(count);

        return setOfValues.size() == setOfCount.size();
    }
}