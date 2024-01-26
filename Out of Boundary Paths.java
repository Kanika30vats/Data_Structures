/**
 * Using Memoization
 * TC : O(4 ^ maxMove)
 * SC : O(maxMove) + O(m * n * maxMove), maxMove is equal to height of recursion call stack
 */
class Solution {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][] directions = new int[][] {{-1,0}, {1,0}, {0,-1}, {0,1}};
        int[][][] dp = new int[51][51][51];
        for(int[][] arr2D : dp) {
            for(int[] arr1D : arr2D) {
                Arrays.fill(arr1D, -1);
            }
        }
        return findPathHelper(m, n, maxMove, startRow, startColumn, directions, dp);
    }

    private int findPathHelper(int m, int n, int maxMove, int startRow, int startColumn, int[][] directions, int[][][] dp) {
        if(startRow < 0 || startRow >= m || startColumn < 0 || startColumn >= n)
            return 1;
        
        if(maxMove <= 0)
            return 0;

        if(dp[startRow][startColumn][maxMove] != -1)
            return dp[startRow][startColumn][maxMove];

        int res = 0;
        int mod = (int)1e9+7;
        for(int[] dir : directions) {
            int newStartRow = startRow + dir[0];
            int newStartColumn = startColumn + dir[1];

            res = (res + findPathHelper(m, n, maxMove - 1, newStartRow, newStartColumn, directions, dp)) % mod;
        }

        dp[startRow][startColumn][maxMove] = res;
        return dp[startRow][startColumn][maxMove];
    }
}