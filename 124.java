/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    // good to have if it's a path problem
    int maxValue = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        helper(root);
        return maxValue;
    }
    
    public int helper(TreeNode node) {
        // terminal
        if (node == null) return 0;
        
        // only take when it's >= 0
        int left = Math.max(0, helper(node.left));
        int right = Math.max(0, helper(node.right));
        
        // since >= 0, we can find "local" maximum
        maxValue = Math.max(maxValue, left + right + node.val);
        
        // report to upper level, if we take this node, how much value can we have
        return Math.max(left, right) + node.val;
    } 
}