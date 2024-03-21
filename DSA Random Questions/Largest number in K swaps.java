//{ Driver Code Starts
import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])throws IOException
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int k = sc.nextInt();
                    String str = sc.next();
                    Solution obj = new Solution();
                    System.out.println(obj.findMaximumNum(str, k));
                }
        }
}
// } Driver Code Ends




class Solution
{
    //Function to find the largest number after k swaps.
    public static String findMaximumNum(String str, int k)
        {
            //code here.
            String maxRes = str;
            maxRes = computeMax(str, k, maxRes, 0);
            return maxRes;
        }
        
    private static String computeMax(String str, int k, String maxRes, int ind) {
        if(k == 0 || ind == str.length())
            return maxRes;
            
        // Find maximum character.
        char maxStr = str.charAt(ind);
        for(int i = ind + 1; i < str.length(); i++) {
            if(maxStr < str.charAt(i))
                maxStr = str.charAt(i);
        }
        
        if(maxStr != str.charAt(ind)) {
            k -= 1;
        }
        
        for(int i = ind; i < str.length(); i++) {
            if(str.charAt(i) == maxStr) {
                str = swap(str, ind, i);
                if(str.compareTo(maxRes)>0)
                    maxRes = str;
                maxRes = computeMax(str, k, maxRes, ind + 1);
                str = swap(str, ind, i);
            }
        }
        return maxRes;
    }
    
    private static String swap(String str, int x, int y) {
        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(x, str.charAt(y));
        sb.setCharAt(y, str.charAt(x));
        
        return sb.toString();
    }
}