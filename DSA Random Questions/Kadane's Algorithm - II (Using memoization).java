//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		//taking total testcases
		int testcases=sc.nextInt();
		while(testcases-->0)
		{
		    //taking size of arary
		    int sizeOfArray=sc.nextInt();
		    int arr[]=new int[sizeOfArray];
		    
		    //inserting elements in the array
		    for(int i=0;i<sizeOfArray;i++)
		    {
		        int x=sc.nextInt();
		        arr[i]=x;
		    }
		    
		    
		    Solution obj=new Solution();
		    
		    //calling maximumSum() method
		    System.out.println(obj.maximumSum(arr,sizeOfArray));
		    
		}
	}
}

// } Driver Code Ends
//User function Template for Java

class Solution
{
    //Function to return the maximum sum without adding adjacent elements.
    public long maximumSum(int arr[], int sizeOfArray)
    {
      //Your code here
      // Using memoization
      long sum = Integer.MIN_VALUE;
      boolean isPositive = false;
      long dp[] = new long[sizeOfArray];
      Arrays.fill(dp, -1);
      
      //Checking if array contains all negative values.
      for(int i = 0; i < sizeOfArray; i++) {
          if(arr[i] < 0) {
              sum = Math.max(sum, arr[i]);
          }
          else {
              isPositive = true;
              break;
          }
      }
      return isPositive ? computeSum(arr, sizeOfArray, 0, dp) : sum;
    }
    
    private long computeSum(int arr[], int n, int i, long[] dp) {
        if(i >= n)
            return 0;
        else if(dp[i] == -1) {
                long s1 = arr[i] + computeSum(arr, n, i + 2, dp);
                long s2 = computeSum(arr, n, i + 1, dp);
                
                dp[i] = (long)Math.max(s1, s2);
            
        }
          
        return dp[i];  
    }

}


//{ Driver Code Starts.



// } Driver Code Ends