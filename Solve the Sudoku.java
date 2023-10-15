//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Driver_class
{
    public static void main(String args[])
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int grid[][] = new int[9][9];
            for(int i = 0; i < 9; i++)
            {
                for(int j = 0; j < 9; j++)
                grid[i][j] = sc.nextInt();
            }
            
            Solution ob = new Solution();
            
            if(ob.SolveSudoku(grid) == true)
                ob.printGrid(grid);
            else
                System.out.print("NO solution exists");
            System.out.println();
            
        }
    }
}




// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find a solved Sudoku. 
    static boolean SolveSudoku(int grid[][])
    {
        // add your code here
        int n = 9;
        
        // Finding empty cell.
        int i = 0, j = 0;
        boolean isEmpty = false;
        for(i = 0; i < n; i++) {
            for(j = 0; j < n; j++) {
                if(grid[i][j] == 0) {
                    isEmpty = true;
                    break;
                }
            }
            if(isEmpty)
                break;
        }
        
        // Base case.
        if(!isEmpty)
            return true;
            
        // Filling empty cells.
        for(int x = 1; x <= n; x++) {
            if(isSafe(i, j, x, n, grid)) {
                grid[i][j] = x;
                if(SolveSudoku(grid))
                    return true;
                grid[i][j] = 0;
            }
        }
        return false;
    }
    
    //Function to print grids of the Sudoku.
    static void printGrid (int grid[][])
    {
        // add your code here
        int n = grid.length;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(grid[i][j] + " ");
            }
        }
    }
    
    private static boolean isSafe(int i, int j, int x, int n, int grid[][]) {
        // Checking whether row or column already contains x.
        for(int k = 0; k < n; k++) {
            if(grid[i][k] == x || grid[k][j] == x)
                return false;
        }
        
        // Checking whether x is already present in subgrid.
        int s = (int)Math.sqrt(n);
        int rowStarting = i - (i % s);
        int colStarting = j - (j % s);
        // Traversing through subgrid.
        for(int l = 0; l < s; l++) {
            for(int m = 0; m < s; m++) {
                if(grid[l + rowStarting][m + colStarting] == x)
                    return false;
            }
        }
        
        return true;
    }
}