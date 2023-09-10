//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Gfg
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            // arraylist of arraylist to represent graph
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            int V = Integer.parseInt(sc.next());
            int E = Integer.parseInt(sc.next());
            
            for(int i =0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
                
            for(int i = 1; i <= E; i++)
            {    int u = Integer.parseInt(sc.next());
                 int v = Integer.parseInt(sc.next());
                 
                 // adding directed edgese between 
                 // vertex 'u' and 'v'
                 adj.get(u).add(v);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.kosaraju(V, adj));
		}
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        //code here
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        boolean[] vis = new boolean[V];
        ArrayList<ArrayList<Integer>> adjListWithReversedEdges = new ArrayList<>();
        int count = 0;
        
        // Pushing vertices in decreasing order of their finish time.
        for(int i = 0; i < V; i++) {
            DFSinDecreadingOrderOfFinishTime(adj, stack, vis, i);
        }
        
        // Reversing all edges.
        for(int i = 0 ; i < V; i++) {
            adjListWithReversedEdges.add(new ArrayList<Integer>());
        }
        reverseEdges(adj, adjListWithReversedEdges);
        
        // Counting strongly connected components.
        Arrays.fill(vis, false);
        while(!stack.isEmpty()) {
            int top = stack.pop();
            if(!vis[top]) {
                count++;
                DFSRec(adjListWithReversedEdges, vis, top);
            }
        }
        
        return count;
    }
    
    private void DFSinDecreadingOrderOfFinishTime(ArrayList<ArrayList<Integer>> adj, ArrayDeque<Integer> stack, boolean[] vis, int i) {
        if(!vis[i]) {
            vis[i] = true;
            for(int vertex : adj.get(i)) {
                DFSinDecreadingOrderOfFinishTime(adj, stack, vis, vertex);
            }
            stack.push(i);
        }
    }
    
    private void reverseEdges(ArrayList<ArrayList<Integer>> adj, ArrayList<ArrayList<Integer>> adjListWithReversedEdges) {
        for(int i = 0; i < adj.size(); i++) {
            for(int j = 0; j < adj.get(i).size(); j++) {
                addEdge(adj.get(i).get(j), i, adjListWithReversedEdges);
            }
        }
    }
    
    private void addEdge(int u, int v, ArrayList<ArrayList<Integer>> adjListWithReversedEdges) {
        adjListWithReversedEdges.get(u).add(v);
    }
    
    private void DFSRec(ArrayList<ArrayList<Integer>> adjListWithReversedEdges, boolean[] vis, int u) {
        vis[u] = true;
        for(int v : adjListWithReversedEdges.get(u)) {
            if(!vis[v]) {
                DFSRec(adjListWithReversedEdges, vis, v);
            }
        }
    }
}
