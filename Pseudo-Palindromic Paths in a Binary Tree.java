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
    public int pseudoPalindromicPaths (TreeNode root) {
        int[] frequency = new int[10];
        return generatePaths(root, frequency);
    }

    private int generatePaths(TreeNode node, int[] frequency) {
        if(node == null)
            return 0;

        frequency[node.val]++;

        if(node.left == null && node.right == null) {
            boolean isPseudoPalindromic = checkPseuduPalindromic(frequency);
            frequency[node.val]--;
            return isPseudoPalindromic ? 1 : 0;
        }

        int leftCount = generatePaths(node.left, frequency);
        int rightCount = generatePaths(node.right, frequency);
        
        frequency[node.val]--;

        return leftCount + rightCount;
    }

    private boolean checkPseuduPalindromic(int[] frequency) {
        int count = 0;
        for(int parityOfElement : frequency) {
            if(parityOfElement % 2 != 0)
                count++;
            
            if(count > 1)
                return false;
        }

        return true;
    }
}