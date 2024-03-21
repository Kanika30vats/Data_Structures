//{ Driver Code Starts


import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{
	static BufferedReader br;
	static PrintWriter ot;
    public static void main(String args[]) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		ot = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine().trim());
		while(t-- > 0){
			String s[] = br.readLine().trim().split(" ");
			int V = Integer.parseInt(s[0]);
			int E = Integer.parseInt(s[1]);
			int edges[][] = new int[E][3];
			for(int i = 0; i < E; i++){
				s = br.readLine().trim().split(" ");
				edges[i][0] = Integer.parseInt(s[0]);
				edges[i][1] = Integer.parseInt(s[1]);
				edges[i][2] = Integer.parseInt(s[2]);
			}
			ot.println(new Solution().spanningTree(V, E, edges));
		}
		ot.close();
	}
}
// } Driver Code Ends


// User function Template for Java

class Solution{
	static int spanningTree(int V, int E, int edges[][]){
	    // Code Here. 
	    // Implementation of MST using Prim's Algo.
	    ArrayList<ArrayList<Pair>> adj = new ArrayList<ArrayList<Pair>>();
	    boolean[] mst = new boolean[V];
	    int[] key = new int[V];
	    int res = 0;
	
	    // Creating adjacency list from edges[][].
	    for(int i = 0; i < V; i++) {
	        adj.add(new ArrayList<>());
	    }
	    for(int i = 0; i < E; i++) {
	        int u = edges[i][0];
	        int v = edges[i][1];
	        int w = edges[i][2];
	        addEdge(adj, u, v, w);
	    }
	    
	    Arrays.fill(key, Integer.MAX_VALUE);
	    key[0] = 0;
	    
	    for(int count = 0; count < V; count++) {
	        // Getting vertex with miminum value.
	        int u = -1;
	        for(int i = 0; i < V; i++) {
	            if(!mst[i] && (u == -1 || key[i] < key[u]))
	                u = i;
	        }
	        
	        mst[u] = true;
	        res += key[u];
	        
	        // Updating values of adjacent vertices of u in key[].
	        for(Pair v : adj.get(u)) {
	            if(!mst[v.node] && key[v.node] > v.weight) {
	                key[v.node] = v.weight;
	            }
	        }
	    }
	    return res;
	}
	
	static void addEdge(ArrayList<ArrayList<Pair>> adj, int u, int v, int w) {
	    adj.get(u).add(new Pair(v, w));
	    adj.get(v).add(new Pair(u, w));
	}
	
	static class Pair {
	    int node;
	    int weight;
	    
	    Pair(int node, int weight) {
	        this.node = node;
	        this.weight = weight;
	    }
	}
}