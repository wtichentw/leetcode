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
    int ans = 0;
    
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        
        helper(root);
        
        return ans - 1;
    }
    
    public int helper(TreeNode node) {
        if (node == null) return 0;
        
        int left  = helper(node.left);
        int right = helper(node.right);
        
        ans = Math.max(ans, left + right + 1);
        
        return Math.max(left, right) + 1;
        
    }
}