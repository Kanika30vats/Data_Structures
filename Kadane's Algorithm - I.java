//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
	    
	    //taking input using Scanner class
		Scanner sc=new Scanner(System.in);
		
		//taking total count of testcases
		int testcases=sc.nextInt();
		while(testcases-->0)
		{
		    //taking size of array
		    int sizeOfArray=sc.nextInt();
		    int arr[]=new int[sizeOfArray];
		    
		    
		    //inserting elements to the array
		    for(int i=0;i<sizeOfArray;i++)
		    {
		        int x=sc.nextInt();
		        arr[i]=x;
		    }
		    Solution obj=new Solution();
		    
		    //calling method maximumSum()
		    System.out.println(obj.maximumSum(arr,sizeOfArray));
		    
		}
	}
}

// } Driver Code Ends
//User function Template for Java


class Solution
{
    //Function to print the maximum contiguous subarray sum ending at each 
    //position in the array and return the overall maximum.
    public long maximumSum(int arr[], int sizeOfArray)
    {
       //code here
       // Using Tabulation.
       long dp[] = new long[sizeOfArray];
       long maxSum = arr[0];
       dp[0] = arr[0];
       System.out.print(dp[0] + " ");
       
       for(int i = 1; i < sizeOfArray; i++) {
           dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
           maxSum = Math.max(maxSum, dp[i]);
           System.out.print(dp[i] + " ");
       }
       
       System.out.println();
       return maxSum;
    }

}


//{ Driver Code Starts.



// } Driver Code Ends