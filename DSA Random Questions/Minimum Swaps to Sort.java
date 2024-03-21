//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[] nums = new int[n];
            String[] S = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++){
                nums[i] = Integer.parseInt(S[i]);
            }
            Solution obj = new Solution();
            int ans = obj.minSwaps(nums);
            System.out.println(ans);
       }
    }
}
// } Driver Code Ends




class Solution
{
    //Function to find the minimum number of swaps required to sort the array.
    public int minSwaps(int nums[])
    {
        // Code here
        int n = nums.length;
        ArrayList<Pair> arr = new ArrayList<>();
        boolean vis[] = new boolean[n];
        int ans = 0;
        
        for(int i = 0; i < n; i++) {
            arr.add(new Pair(nums[i], i));
        }
        
        Collections.sort(arr);
        
        for(int i = 0; i < n; i++) {
            if(arr.get(i).key != nums[i]) {
                int cycle = 0;
                int j = i;
                while(!vis[j]) {
                    vis[j] = true;
                    j = arr.get(j).val;
                    cycle++;
                }
                if(cycle > 0)
                    ans += (cycle-1);
            }
        }
        return ans;
        
    }
}

class Pair implements Comparable<Pair> {
    int key;
    int val;
    
    Pair(int key, int val) {
        this.key = key;
        this.val = val;
    }
    
    @Override
    public int compareTo(Pair pair) {
        return this.key - pair.key;
    }
}