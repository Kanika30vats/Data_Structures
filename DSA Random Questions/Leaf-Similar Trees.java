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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> tree1Leaf = new ArrayList<>();
        ArrayList<Integer> tree2Leaf = new ArrayList<>();
        generateLeafSequence(root1, tree1Leaf);
        generateLeafSequence(root2, tree2Leaf);
        
        return tree1Leaf.equals(tree2Leaf);
    }

    private void generateLeafSequence(TreeNode node, ArrayList<Integer> treeLeaf) {
        if(node == null)
            return;
        if(node.left == null && node.right == null)
            treeLeaf.add(node.val);
        
        generateLeafSequence(node.left, treeLeaf);
        generateLeafSequence(node.right, treeLeaf);
    }
}