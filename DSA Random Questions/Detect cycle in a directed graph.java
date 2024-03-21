//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        boolean vis[] = new boolean[V];
        boolean recStack[] = new boolean[V];
        
        for(int i = 0; i < V; i++) {
            if(!vis[i]) {
                if(DFSRec(V, adj, i, vis, recStack))
                    return true;
            }
        }
        return false;
    }
    
    private boolean DFSRec(int V, ArrayList<ArrayList<Integer>> adj, int u, boolean vis[], boolean recStack[]) {
        if(!vis[u]) {
            vis[u] = true;
            recStack[u] = true;
        }
        
        for(int v : adj.get(u)) {
            if(vis[v] && recStack[v])
                return true;
            else if(!vis[v]) {
                if(DFSRec(V, adj, v, vis, recStack))
                    return true;
            }
        }
        
        recStack[u] = false;
        return false;
    }
}