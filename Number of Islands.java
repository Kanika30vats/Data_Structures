class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean vis[][] = new boolean[m][n];
        int count = 0;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1' && !vis[i][j]) {
                    count++;
                    DFSRec(grid, i, j, vis, m, n);
                }
            }
        }
        return count;
    }

    private void DFSRec(char[][] grid, int x, int y, boolean vis[][], int m, int n) {
        int delX[] = {0, -1, 0, 1};
        int delY[] = {-1, 0, 1, 0};

        vis[x][y] = true;

        for(int i = 0; i < 4; i++) {
            int newX = x + delX[i];
            int newY = y + delY[i];

            if(newX >= 0 && newX < m && newY >=0 && newY < n && !vis[newX][newY] && grid[newX][newY] == '1') {
                DFSRec(grid, newX, newY, vis, m, n);
            }
        }
    }
}