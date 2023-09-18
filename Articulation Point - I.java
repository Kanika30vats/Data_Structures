//{ Driver Code Starts
// Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
            for(int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            ArrayList<Integer>ans = obj.articulationPoints(V, adj);
            for (int i =0 ;i < ans.size (); i++) 
                System.out.print (ans.get (i) + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution
{
    private int timer = 1;
    //Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> articulationPoints(int V,ArrayList<ArrayList<Integer>> adj)
    {
        // Code here
        ArrayList<Integer> res = new ArrayList<>();
        int[] low = new int[V];
        int[] disc = new int[V];
        // Array to handle multiple pushes of the same vertex as articulation points in res.
        int[] articulationPoints = new int[V];
        
        for(int i = 0; i < V; i++) {
            if(disc[i] == 0) {
                computeArticulationPoints(adj, articulationPoints, low, disc, i, -1);
            }
        }
        
        for(int i = 0; i < V; i++) {
            if(articulationPoints[i] == 1) {
                res.add(i);
            }
        }
        Collections.sort(res);
        return (res.isEmpty()) ? new ArrayList<>(Arrays.asList(-1)) : res;
    }
    
    private void computeArticulationPoints(ArrayList<ArrayList<Integer>> adj, int[] articulationPoints, int[] low, int[] disc, int u, int parent) {
        disc[u] = low[u] = timer;
        timer++;
        
        int children = 0;
        
        for(int v : adj.get(u)) {
            if(disc[v] == 0) {
                // Increment children only when child is not visited. This condition is to handle self loops.
                // Hence, incremented children inside disc[v]==0 condition.
                children++;
                computeArticulationPoints(adj, articulationPoints, low, disc, v, u);
                low[u] = Math.min(low[v], low[u]);
                
                // Check for nodes other than root.
                if(parent != -1 && low[v] >= disc[u]) {
                    articulationPoints[u] = 1;
                }
            }
            else if(parent != u) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }
        
        // Check for root node.
        if(parent == -1 && children > 1) {
            articulationPoints[u] = 1;
        }
    }
}