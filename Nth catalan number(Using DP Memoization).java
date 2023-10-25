//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            Solution obj = new Solution();
            int res = obj.findCatalan(n);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends



class Solution {
    public static int findCatalan(int n) {
        // code here
        int memo[] = new int[n + 1];
        return computeCatalan(n, memo);
    }
    
    private static int computeCatalan(int n, int memo[]) {
        int mod = (int)1e9+7;
        if(n == 0 || n == 1)
            return 1;
        
        if(memo[n] != 0)
            return memo[n];
            
        long res = 0;
        for(int i = 0; i < n; i++) {
            res += (1L * computeCatalan(i, memo) * computeCatalan(n - i - 1, memo)) % mod;
        }
        memo[n] = (int)(res % mod);
        return memo[n];
    }
}
        
