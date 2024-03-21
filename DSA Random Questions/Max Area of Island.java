class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        ArrayDeque<Pair> queue = new ArrayDeque<>();
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, -1, 0, 1};

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(!vis[i][j] && grid[i][j] == 1) {
                    queue.add(new Pair(i, j));
                    vis[i][j] = true;
                    res = Math.max(res, BFS(grid, i, j, m, n, vis, queue, delRow, delCol));
                }
            }
        }
        return res;
    }

    private int BFS(int[][] grid, int i, int j, int m, int n, boolean[][] vis, ArrayDeque<Pair> queue, int[] delRow, int[] delCol) {
        int count = 0;
        while(!queue.isEmpty()) {
            Pair front = queue.remove();
            count++;
            for(int k = 0; k < 4; k++) {
                int newRow = front.x + delRow[k];
                int newCol = front.y + delCol[k];

                if(newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && grid[newRow][newCol] == 1 && !vis[newRow][newCol]) {
                    queue.add(new Pair(newRow, newCol));
                    vis[newRow][newCol] = true;
                }
            }
        }
        return count;
    }
}

class Pair {
    int x;
    int y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}