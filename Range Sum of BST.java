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
    public int rangeSumBST(TreeNode root, int low, int high) {
        Sum res = new Sum(0);
        calcRangeSum(root, low, high, res);
        return res.sum;
    }

    private void calcRangeSum(TreeNode node, int low, int high, Sum res) {
        if(node == null)
            return;
        if(node.val >= low && node.val <= high) 
            res.sum += node.val;
        calcRangeSum(node.left, low, high, res);    
        calcRangeSum(node.right, low, high, res);
    }
    
    class Sum {
        int sum;
        Sum(int sum) {
            this.sum = sum;
        }
    }
}