//{ Driver Code Starts
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
            ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
            for(int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
            }
            Solution obj = new Solution();
            int ans = obj.findMotherVertex(V, adj);
            System.out.println(ans);
       }
    }
}
// } Driver Code Ends



class Solution
{
    //Function to find a Mother Vertex in the Graph.
    public int findMotherVertex(int V, ArrayList<ArrayList<Integer>>adj)
    {
        // Code here
        boolean vis[] = new boolean[V];
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        MyWrapper myWrapper = new MyWrapper();
        
        for(int i = 0; i < V; i++) {
            if(!vis[i])
                DFSRec(i, adj, stack, vis);
        }
        
        Arrays.fill(vis, false);
        checkIsMotherVertex(stack.peek(), adj, myWrapper, vis);
        
        return (myWrapper.count == V) ? stack.peek() : -1;
        
    }
    
    /**
     * Using Kosaraju's Algo Step1. (Traversing vertices in decreasing order of finish time)
     */
    private void DFSRec(int i, ArrayList<ArrayList<Integer>> adj, ArrayDeque<Integer> stack, boolean vis[]) {
        vis[i] = true;
        for(int v : adj.get(i)) {
            if(!vis[v])
                DFSRec(v, adj, stack, vis);
        }
        stack.push(i);
    }
    
    /**
     * To check whether top of stack is a mother vertex or not.
     */
    private void checkIsMotherVertex(int u, ArrayList<ArrayList<Integer>> adj, MyWrapper myWrapper, boolean vis[]) {
        myWrapper.count++;
        vis[u] = true;
        for(int v : adj.get(u)) {
            if(!vis[v]) 
                checkIsMotherVertex(v, adj, myWrapper, vis);
        }
    }
}

class MyWrapper {
    int count;
    
    MyWrapper() {
        this.count = 0;
    }
}