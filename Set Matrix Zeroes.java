class Solution {
    public void setZeroes(int[][] matrix) {
        boolean flag = false; //to check a[0][0] 
        int m = matrix.length;
        int n = matrix[0].length;
        
        // Traverse whole matrix
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(matrix[i][j] == 0) {
                    if(j!=0) {
                        matrix[0][j] = 0;
                        matrix[i][0] = 0;
                    }
                    else
                        flag = true;
                }
            }
        }

        // Traverse except first row and first col
        for(int i=1;i<m;i++) {
            for(int j=1;j<n;j++) {
                if(matrix[0][j] == 0 || matrix[i][0] == 0)
                    matrix[i][j] = 0;
            }
        }

        // Set first row as 0 if a[0][0] is 0.
        if(matrix[0][0] == 0)
        {
            for(int j=1;j<n;j++) {
                matrix[0][j] = 0;
            }
        }

        // Set first col as 0 if flag is 0.
        if(flag) {
            for(int i=0;i<m;i++) {
                matrix[i][0] = 0;
            }
        }
    }
}