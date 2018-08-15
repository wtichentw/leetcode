/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode convertBST(TreeNode root) {

        myTraversal(root, 0);
        
        return root;
    }
    
    public int myTraversal(TreeNode node, int preSum) {
        if (node == null) return 0;
        
        // if node.right, need new presum
        if (node.right != null) 
            preSum = myTraversal(node.right, preSum);
        
        node.val += preSum;
        
        // if node.left, add left part or just node.val
        if (node.left != null)
            return myTraversal(node.left, node.val);
        else 
            return node.val;
    }
    
}