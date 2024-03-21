class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> res = new ArrayList<>();
        boolean vis[] = new boolean[n];
        DFSRec(0, n-1, res, new ArrayList<>(), graph, vis);
        return res;
    }

    private static void DFSRec(int u, int v, List<List<Integer>> res, ArrayList<Integer> path, int[][] graph, boolean vis[]) {
        path.add(u);
        if(u == v) {
            res.add(new ArrayList<>(path));
        }
        else {
            vis[u] = true;
            for(int vertex : graph[u]) {
                    DFSRec(vertex, v, res, path, graph, vis);
            }
        }

        vis[u] = false;
        path.remove(path.size()-1);
    }
}