/**
 * Better solution : Using DP
 *  TC : O(n*m), SC : O(n*m) +  rec call stack space
 */
// class Solution {
//     public int uniquePaths(int m, int n) {
//         int[][] dp = new int[m][n];
//         for(int row=0;row<m;row++)
//             Arrays.fill(dp[row], -1);
//         return computeUniquePaths(0, 0, m, n, dp);
//     }

//     private int computeUniquePaths(int i, int j, int m, int n, int[][] dp) {
//         if(i == m-1 && j == n-1)
//             return 1;
//         if(i >= m || j >= n)
//             return 0;
        
//         if(dp[i][j] == -1)
//             dp[i][j] = computeUniquePaths(i+1, j, m, n, dp) + computeUniquePaths(i, j+1, m, n, dp);
        
//         return dp[i][j];
//     }
// }

/**
 * Optimal solution using combination.
 * TC:O(m-1), SC:O(1)
 */
class Solution {
    public int uniquePaths(int m, int n) {
        int N = m+n-2; // Total number of directions.
        int R = m-1; // Because number of downward directions would always be number of rows - 1.
        double uniquePaths = 1;

        // Computing nCr.
        for(int i=1;i<=R;i++) {
            uniquePaths = uniquePaths * (N-R+i) / i ;
        }
        return (int)uniquePaths;
    }
}