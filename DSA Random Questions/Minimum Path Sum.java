class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dist = new int[m][n];

        for(int row[] : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dist[0][0] = grid[0][0];

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, -1, 0, 1};
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                dijkstra(m , n, i, j , delRow, delCol, dist, grid);
            }
        }
        return dist[m-1][n-1];
    }

    private void dijkstra(int m, int n, int i, int j, int[] delRow, int[] delCol, int[][] dist, int[][] grid) {
        for(int k = 0; k < 4; k++) {
            int newRow = i + delRow[k];
            int newCol = j + delCol[k];

            if(newRow >= 0 && newRow < m && newCol >= 0 && newCol < n) {
                // Perform relax operation
                if(dist[newRow][newCol] > dist[i][j] + grid[newRow][newCol]) {
                    dist[newRow][newCol] = dist[i][j] + grid[newRow][newCol];
                }
            }
        }
    }
}