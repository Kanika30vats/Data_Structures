//{ Driver Code Starts
// Initial Template for Java
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
            ArrayList<ArrayList<Integer>> ptr = ob.tarjans(V, adj);

            for(int i=0; i<ptr.size(); i++)
            {
                for(int j=0; j<ptr.get(i).size(); j++)
                {
                    if(j==ptr.get(i).size()-1)
                        System.out.print(ptr.get(i).get(j));
                    else
                        System.out.print(ptr.get(i).get(j) + " ");
                }
                System.out.print(",");
            }
            System.out.println();
		}
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    private int timer = 1;
    //Function to return a list of lists of integers denoting the members 
    //of strongly connected components in the given graph.  
    public ArrayList<ArrayList<Integer>> tarjans(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // code here
        int[] low = new int[V];
        int[] disc = new int[V];
        boolean[] inStack = new boolean[V];
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        
        for(int i = 0; i < V; i++) {
            if(disc[i] == 0) {
                dfsTarjans(adj, low, disc, inStack, stack, res, i);
            }
        }
        
        sortRes(res);
        
        return res;
    }
    
    private void dfsTarjans(ArrayList<ArrayList<Integer>> adj, int[] low, int[] disc, boolean[] inStack, ArrayDeque<Integer> stack, ArrayList<ArrayList<Integer>> res, int u) {
        low[u] = disc[u] = timer;
        timer++;
        stack.push(u);
        inStack[u] = true;
        
        for(int v : adj.get(u)) {
            if(disc[v] == 0) {
                dfsTarjans(adj, low, disc, inStack, stack, res, v);
                
                low[u] = Math.min(low[u], low[v]);
            }
            // Checking for backedge. Ignoring cross edges.
            else if(inStack[v]) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }
        
        if(low[u] == disc[u]) {
            ArrayList<Integer> scc = new ArrayList<>();
            while(stack.peek() != u) {
                int top = stack.pop();
                scc.add(top);
                inStack[top] = false;
            }
            if(!stack.isEmpty() && stack.peek() == u) {
                int top = stack.pop();
                scc.add(top);
                inStack[top] = false;
            }
            Collections.sort(scc);
            res.add(scc);
        }
    }
    
    private void sortRes(ArrayList<ArrayList<Integer>> res) {
        Collections.sort(res, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> res1, ArrayList<Integer> res2) {
                int minSize = Math.min(res1.size(), res2.size());
                int val = 0;
                for(int i = 0; i < minSize && val == 0; i++) {
                    val = res1.get(i).compareTo(res2.get(i));
                }
                return (val == 0) ? -1 : val;
            }
        });
    }
}