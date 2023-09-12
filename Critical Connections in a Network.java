class Solution {
    private int count = 1;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        int[] low = new int[n];
        int[] disc = new int[n];
        int[] vis = new int[n];
        List<List<Integer>> criticalConnection = new ArrayList<>();
        List<List<Integer>> adj = new ArrayList<>();

        //create Adjacency List
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<Integer>());
        }
        for(int i = 0; i < connections.size(); i++) {
            int u = connections.get(i).get(0);
            int v = connections.get(i).get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        for(int i = 0; i < n; i++) {
            if(vis[i] == 0) {
                dfs(adj, i, low, disc, vis, criticalConnection, -1);
            }
        }

        return criticalConnection;
    }

    private void dfs(List<List<Integer>> adj, int u, int[] low, int[] disc, int[] vis, List<List<Integer>> criticalConnection, int parent) {
        vis[u] = 1;
        low[u] = disc[u] = count;
        count++;

        for(Integer v : adj.get(u)) {
            if(vis[v] == 0) {
                dfs(adj, v, low, disc, vis, criticalConnection, u);

                if(low[v] > disc[u]) {
                    criticalConnection.add(Arrays.asList(u, v));
                }
            }
            if(v != parent && vis[v] == 1) {
                low[u] = Math.min(low[v], low[u]);
            }
        }
    }
}