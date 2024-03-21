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
      // Using Tabulation.
      long maxSum = Math.max(arr[0], arr[1]);
      long sum[] = new long[sizeOfArray];
      long dp[] = new long[sizeOfArray]; 
      
      dp[0] = arr[0];
      dp[1] = maxSum;
      sum[0] = arr[0];
      sum[1] = arr[1];
      
      for(int i = 2; i < sizeOfArray; i++) {
          sum[i] = (long)Math.max(arr[i], arr[i] + dp[i - 2]);
          maxSum = (long)Math.max(maxSum, sum[i]);
          dp[i] = (long)Math.max(sum[i], dp[i - 1]);
      }
      return maxSum;
    }
}


//{ Driver Code Starts.



// } Driver Code Ends