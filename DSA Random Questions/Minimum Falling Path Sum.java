/**
 * RECURSIVE SOLUTION - TLE
 * TC : O(3^n), where n is number of rows
 * SC : O(n) recursion call stack space
 */
    // class Solution {
    //     public int minFallingPathSum(int[][] matrix) {
    //         int row = matrix.length;
    //         int col = matrix[0].length;
    //         int minSum = (int)1e8;
    //         for(int i = 0; i < col; i++) 
    //             minSum = Math.min(minSum, computeMinFallingSum(row - 1, i, matrix));
    //         return minSum;
    //     }

    //     private int computeMinFallingSum(int i, int j, int[][] matrix) {
    //         if(j < 0 || j >= matrix[0].length)
    //             return (int)1e8;
            
    //         if(i == 0)
    //             return matrix[i][j];

    //         int upperLeft = matrix[i][j] + computeMinFallingSum(i - 1, j - 1, matrix);
    //         int upperMiddle = matrix[i][j] + computeMinFallingSum(i - 1, j, matrix);
    //         int upperRight = matrix[i][j] +computeMinFallingSum(i - 1, j + 1, matrix);

    //         return Math.min(upperLeft, Math.min(upperMiddle, upperRight));
    //     }
    // }


/**
 * OPTIMIZATION USING MEMOIZATION - TLE 
 * TC : O(n*m) -> TC could be lot more than O(n*m) due to recursive calls, hence getting TLE
 * SC : O(n*m) + O(n) recursion call stack space
 */
    // class Solution {
    //     public int minFallingPathSum(int[][] matrix) {
    //         int row = matrix.length;
    //         int col = matrix[0].length;
    //         int minSum = (int)1e8;
    //         int dp[][] = new int[row][col];
    //         for(int i = 0; i < row; i++) {
    //             Arrays.fill(dp[i], -1);
    //         }
    //         for(int i = 0; i < col; i++) 
    //             minSum = Math.min(minSum, computeMinFallingSum(row - 1, i, matrix, dp));
    //         return minSum;
    //     }

    //     private int computeMinFallingSum(int i, int j, int[][] matrix, int dp[][]) {
    //         if(j < 0 || j >= matrix[0].length)
    //             return (int)1e8;
            
    //         if(i == 0)
    //             return matrix[i][j];

    //         if(dp[i][j] != -1)
    //             return dp[i][j];

    //         int upperLeft = matrix[i][j] + computeMinFallingSum(i - 1, j - 1, matrix, dp);
    //         int upperMiddle = matrix[i][j] + computeMinFallingSum(i - 1, j, matrix, dp);
    //         int upperRight = matrix[i][j] +computeMinFallingSum(i - 1, j + 1, matrix, dp);

    //         return dp[i][j] = Math.min(upperLeft, Math.min(upperMiddle, upperRight));
    //     }
    // }


/**
 * TABULATION - Accepted
 * TC : O(n*m) + O(m), where n is number of rows and m is number of columns.
 * SC : O(n*m)
 */
    // class Solution {
    //     public int minFallingPathSum(int[][] matrix) {
    //         int row = matrix.length;
    //         int col = matrix[0].length;
    //         int minSum = (int)1e8;
    //         int dp[][] = new int[row][col];
    //         for(int j = 0; j < col; j++) {
    //             dp[0][j] = matrix[0][j];
    //         }
    //         for(int i = 1; i < row; i++) {
    //             for(int j = 0; j < col; j++) {
    //                 int leftDiagonal = matrix[i][j];
    //                 leftDiagonal += (j-1 >= 0) ? (dp[i-1][j-1]) : ((int)1e8);
    //                 int upperMiddle = matrix[i][j] + dp[i - 1][j];
    //                 int rightDiagonal = matrix[i][j];
    //                 rightDiagonal += (j+1 < col) ? (dp[i-1][j+1]) : ((int)1e8);
    //                 dp[i][j] = Math.min(leftDiagonal, Math.min(upperMiddle, rightDiagonal));
    //             }
    //         }
    //         for(int j = 0; j < col; j++) {
    //             minSum = Math.min(minSum, dp[row - 1][j]);
    //         }
    //         return minSum;
    //     }
    // }


/**
 * TABULATION WITH SPACE OPTIMIZATION
 * TC : O(n*m)
 * SC : O(n)
 */
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int minSum = (int)1e8;
        int[] prev = new int[col];
        int[] curr = new int[col];
        for(int j = 0; j < col; j++) {
            prev[j] = matrix[0][j];
        }
        for(int i = 1; i < row; i++) {
            for(int j = 0; j < col; j++) {
                int leftDiagonal = matrix[i][j];
                leftDiagonal += (j-1 >= 0) ? (prev[j-1]) : ((int)1e8);
                int upperMiddle = matrix[i][j] + prev[j];
                int rightDiagonal = matrix[i][j];
                rightDiagonal += (j+1 < col) ? (prev[j+1]) : ((int)1e8);
                curr[j] = Math.min(leftDiagonal, Math.min(upperMiddle, rightDiagonal));
            }
            prev = curr;
        }
        for(int j = 0; j < col; j++) {
            minSum = Math.min(minSum, curr[j]);
        }
        return minSum;
    }
}