//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[][] matrix = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++)
                    matrix[i][j] = Integer.parseInt(S[j]);
            }
            Solution ob = new Solution();
            int[][] ans = ob.ShortestDistance(matrix);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}

// } Driver Code Ends


class Solution
{
    public int[][] ShortestDistance(int[][] matrix)
    {
        // Code here
        int n = matrix.length;
        int[][] resultantMatrix = new int[n][n];
        
        if(computeShortestDistance(0, 0, resultantMatrix, n, matrix))
            return resultantMatrix;
        
        return new int[][] {{-1}};
    }
    
    private boolean computeShortestDistance(int x, int y, int[][] resultantMatrix, int n, int[][] matrix) {
        
        if(x >= n || y >= n) 
            return false;
        
        resultantMatrix[x][y] = 1;
        
        if(x == n-1 && y == n-1) {
            return true;
        }
        
        int jumps = matrix[x][y];
        
        for(int i = 1; i <= jumps; i++) {
            if(computeShortestDistance(x, y + i, resultantMatrix, n, matrix))
                return true;
            if(computeShortestDistance(x + i, y, resultantMatrix, n, matrix))
                return true;
        }
        resultantMatrix[x][y] = 0;
        return false;
    }
}