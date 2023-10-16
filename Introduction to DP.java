//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            Solution obj = new Solution();
            long topDownans = obj.topDown(n);
            long bottomUpans = obj.bottomUp(n);
            if (topDownans != bottomUpans)
                System.out.println(-1);
            else
                System.out.println(topDownans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {

    static long topDown(int n) {
        // code here
        
        // Using Memoization.
        long memo[] = new long[n+1];
        Arrays.fill(memo, -1);
        return dpUsingMemoization(n, memo);
    }
    
    private static long mod = (long)1e9+7;
    
    private static long dpUsingMemoization(int n, long memo[]) {
        if(memo[n] == -1) {
            long res;
            if(n == 0 || n == 1) {
                res = n;
            } 
            else {
                res = dpUsingMemoization(n - 1, memo) + dpUsingMemoization(n - 2, memo);
            }
            memo[n] = res;
        }
        return memo[n] % mod;
    }

    static long bottomUp(int n) {
        // code here
        
        // Using Tabulation.
        long res[] = new long[n+1];
        res[0] = 0;
        res[1] = 1;
        
        for(int i = 2; i <= n; i++) {
            res[i] = (res[i - 1] + res[i - 2]) % mod;
        }
        return res[n];
    }
}
