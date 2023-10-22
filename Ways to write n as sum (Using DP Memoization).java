//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG{

  public static void main (String[] args)  {
     Scanner s=new Scanner(System.in);
     int t=s.nextInt();
     while(t-->0){
         int n=s.nextInt();
         Solution obj = new Solution();
         System.out.println(obj.countWays(n));
     }

   }
}

// } Driver Code Ends




class Solution
{
    // function to count ways in which n can be
    // expressed as the sum of two or more integers
    int countWays(int n)
    {
    
         // your code here
         int memo[][] = new int[n+1][n+1];
         for(int[] row : memo) {
             Arrays.fill(row, -1);
         }
         return dp(n, memo, 1, n);
    }
    
    private int dp(int n, int memo[][], int i, int sum) {
        if(sum == 0)
            return 1;
        if(sum < 0)
            return 0;
        if(i == n)
            return 0;
            
        if(memo[i][sum] != -1)
            return memo[i][sum];
       
        memo[i][sum] = dp(n, memo, i, sum - i) + dp(n, memo, i + 1, sum);
        return memo[i][sum];
        
    }
}
