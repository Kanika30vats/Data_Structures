/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int amountOfTime(TreeNode root, int start) {
        Map<Integer, ArrayList<Integer>> adjList = new HashMap<>();
        convertToGraph(root, adjList);
        return computeInfectionTime(start, adjList);
    }

    private void convertToGraph(TreeNode node, Map<Integer, ArrayList<Integer>> adjList) {
        if(node == null)
            return;
        
        if(node.left != null) {
            addEdge(node.val, node.left.val, adjList);
        }

        if(node.right != null) {
            addEdge(node.val, node.right.val, adjList);
        }

        convertToGraph(node.left, adjList);
        convertToGraph(node.right, adjList);
    }

    private void addEdge(int node1, int node2, Map<Integer, ArrayList<Integer>> adjList) {
        adjList.computeIfAbsent(node1, k -> new ArrayList<>()).add(node2);
        adjList.computeIfAbsent(node2, k -> new ArrayList<>()).add(node1);
    }

    private int computeInfectionTime(int start, Map<Integer, ArrayList<Integer>> adjList) {
        Queue<Integer> q = new ArrayDeque<>();
        int timer = 0;
        HashSet<Integer> vis = new HashSet<>();
        q.add(start);
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int front = q.remove();
                vis.add(front);
                if(adjList.containsKey(front)) {
                    for(int nodeVal : adjList.get(front)) {
                        if(!vis.contains(nodeVal)) {
                            q.add(nodeVal);
                        }
                    }
                }
            }
            timer++;
        }
        return timer - 1;
    }
}