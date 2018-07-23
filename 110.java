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
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        
        return helper(root) == Integer.MIN_VALUE? false: true;
    }
    
    public int helper(TreeNode node) {
        if (node.left == null && node.right == null) return 1;
        
        int lh = 0, rh = 0;
        if (node.left != null)  lh = helper(node.left);
        if (node.right != null) rh = helper(node.right);
        
        if (Math.abs(lh - rh) > 1 || lh == Integer.MIN_VALUE || rh == Integer.MIN_VALUE) return Integer.MIN_VALUE;
        else return Math.max(lh, rh) + 1;
    }
}