//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for(int i = 0; i < V+1; i++)
                list.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++)
            {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
                list.get(v).add(u);
            }
            int c = sc.nextInt();
            int d = sc.nextInt();
            
            Solution ob = new Solution();
            
            System.out.println(ob.isBridge(V,list,c,d));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution
{
    private static int timer = 1;
    //Function to find if the given edge is a bridge in graph.
    static int isBridge(int V, ArrayList<ArrayList<Integer>> adj,int c,int d)
    {
        // code here
        int res = 0;
        boolean[] vis = new boolean[V];
        int[] low = new int[V];
        int[] disc = new int[V];
        
        for(int i = 0; i < V; i++){
            if(!vis[i])
                if(dfs(adj, c, d, res, vis, low, disc, i, -1) == 1)
                    return 1;
        }
        return 0;
    }
    
    private static int dfs(ArrayList<ArrayList<Integer>> adj,int c,int d, int res, boolean[] vis, int[] low, int[] disc, int u, int parent) {
        vis[u] = true;
        low[u] = disc[u] = timer;
        timer++;
        for(int v : adj.get(u)) {
            if(!vis[v]) {
                res = dfs(adj, c, d, res, vis, low, disc, v, u);
                
                low[u] = Math.min(low[u], low[v]);
                
                if(((u == c && v == d) || (u == d && v == c)) && low[v] > disc[u]) {
                    res = 1;
                    break;
                }
            }
            else if(v != parent) {
                low[u] = Math.min(low[u], low[v]);
            }
        }
        return res;
    }
}