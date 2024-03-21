//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		while(t-->0)
		{
		    int n=sc.nextInt();
		    sc.nextLine();
		    String arr[]=new String[n];
		    for(int i=0;i<n;i++)
		    {
		        arr[i]=sc.nextLine();
		        
		    }
		    new Solution().check(arr,n);
		    
		    
		}
	}


	
}

class Node
{
    public boolean isEndOfWord;
    public TreeMap<Character,Node>mp;
    public Node()
    {
        isEndOfWord=false;
        mp=new TreeMap<>();
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public static void check(String arr[],int n)
    {
        //Your code here
        Trie root = new Trie();
        
        for(int i = 0; i < n; i++) 
        {
            Trie curr = root;
            String res = "";
            boolean isPrinted = false;
            
            for(int j = 0; j < arr[i].length(); j++) {
                int index = arr[i].charAt(j) - 'a';
                if(curr.children[index] == null) {
                    curr.children[index] = new Trie();
                    curr = curr.children[index];
                    curr.count++;
                    if(isPrinted == false) {
                        res = res + arr[i].charAt(j);
                        isPrinted = true;
                    }
                }
                else {
                    curr = curr.children[index];
                    res = res + arr[i].charAt(j);
                    curr.count++;
                }
            }
            if(curr.isEnd == true) {
                System.out.println(res + " " + curr.count);
            }
            else {
                System.out.println(res);
                curr.isEnd = true;
            }
        }
    }
}

class Trie {
    Trie children[];
    boolean isEnd;
    int count;
    
    Trie() {
        children = new Trie[26];
        isEnd = false;
        count = 0;
    }
}
