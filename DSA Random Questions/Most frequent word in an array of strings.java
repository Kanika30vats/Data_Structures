//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main(String[] args) throws IOException{
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		while(t-->0)
		{
		    int n=sc.nextInt();
		    sc.nextLine();
		    Solution obj = new Solution();
		    String arr[]=sc.nextLine().split(" ");
		    System.out.println(obj.mostFrequentWord(arr, n));
		    
		}
	}
}

// } Driver Code Ends
//User function Template for Java


class Solution
{
    //Function to find most frequent word in an array of strings.
    public String mostFrequentWord(String arr[],int n)
    {
        // code here
        HashMap<String, Integer> map = new HashMap();
        String res = "";
        int count = 0;
        
        for(int i = 0; i < n; i++) {
            if(map.containsKey(arr[i]))
                map.put(arr[i], map.get(arr[i]) + 1);
            else
                map.put(arr[i], 1);
        }
        
        for(int i = 0; i < n; i++) {
            if(map.get(arr[i]) >= count)
            {
                count = map.get(arr[i]);
                res = arr[i];
                map.put(arr[i], map.get(arr[i]) - 1);
            }
        }
        return res;
    }
}
