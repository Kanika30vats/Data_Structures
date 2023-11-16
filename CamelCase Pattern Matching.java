//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            String[] Dictionary=read.readLine().split(" ");
            String Pattern=read.readLine();
            Solution ob = new Solution();
            ArrayList <String> ans=ob.CamelCase(N,Dictionary,Pattern);
            for(String u:ans)
             System.out.print(u+" ");
            System.out.println(); 
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    ArrayList<String> CamelCase(int N,String[] Dictionary,String Pattern){
        //code here
        ArrayList<String> res = new ArrayList<>();
        
        for(int i = 0; i < N; i++) {
            if(compareCamelCase(Dictionary[i], Pattern))
                res.add(Dictionary[i]);
        }
        
        if(res.isEmpty())
            res.add("-1");
        else
            Collections.sort(res);
            
        return res;
    }
    
    private boolean compareCamelCase(String str, String pattern) {
        int j = 0;
        for(int i = 0; i < str.length(); i++) {
            if(Character.isUpperCase(str.charAt(i))) {
                if(str.charAt(i) == pattern.charAt(j)) {
                    j++;
                }
                else{
                    break;
                }
            }
            if(j == pattern.length()) {
                return true;
            }
        }
        return false;
    }
}