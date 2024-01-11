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
    public int maxAncestorDiff(TreeNode root) {
        Value val = new Value();
        computeMaxAncestorDiff(root, val);
        return val.maxValue;
    }

    private int[] computeMaxAncestorDiff(TreeNode node, Value val) {
        if(node == null)
            return new int[] {Integer.MAX_VALUE, Integer.MIN_VALUE};
        
        if(node.left == null && node.right == null) {
            return new int[] {node.val, node.val};
        }

        int[] leftSubTree = computeMaxAncestorDiff(node.left, val);
        int[] rightSubTree = computeMaxAncestorDiff(node.right, val);

        int min = Math.min(leftSubTree[0], rightSubTree[0]);
        int max = Math.max(leftSubTree[1], rightSubTree[1]);

        int maxDiff = Math.max(Math.abs(node.val - min), Math.abs(node.val - max));
        val.maxValue = Math.max(maxDiff, val.maxValue);

        min = Math.min(node.val, min);
        max = Math.max(node.val, max);

        return new int[] {min, max};
    }

    class Value {
        int maxValue;
    }
}