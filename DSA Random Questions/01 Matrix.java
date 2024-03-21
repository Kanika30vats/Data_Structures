class Solution {
    public int[][] updateMatrix(int[][] mat) {
        
        int m = mat.length;
        int n = mat[0].length;

        Queue<Node> q = new LinkedList<>();
        boolean vis[][] = new boolean[m][n];
        int res[][] = new int[m][n];

        int delX[] = {0, -1, 0, 1};
        int delY[] = {1, 0, -1, 0};

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(mat[i][j] == 0) {
                    q.add(new Node(i, j, 0));
                    vis[i][j] = true;
                }
            }
        }

        while(!q.isEmpty()) {
            Node front = q.remove();
            res[front.x][front.y] = front.dist;

            for(int i = 0; i < 4; i++) {
                int newX = front.x + delX[i];
                int newY = front.y + delY[i];

                if(newX >= 0 && newX < m & newY >=0 && newY < n && !vis[newX][newY]) {
                    vis[newX][newY] = true;
                    q.add(new Node(newX, newY, front.dist + 1));
                }
            }
        }

        return res;
    }
}

class Node {
    int x;
    int y;
    int dist;

    Node(int x, int y, int d) {
        this.x = x;
        this.y = y;
        this.dist = d;
    }
}