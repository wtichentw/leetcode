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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);        
    }
    
    public TreeNode helper(int[] pre, int preBeg, int preEnd, int[] in, int inBeg, int inEnd) {
        if (preBeg > preEnd || inBeg > inEnd) return null;
        
        TreeNode node = new TreeNode(pre[preBeg]);
        
        // get root index in inorder
        int idx = inBeg; 
        for (idx = inBeg; idx <= inEnd; idx++) {
            if (in[idx] == node.val) break;
        }
        
        // len of left subtree
        int len = idx - inBeg;
        
        // pre consume first one
        // in  consume middle one 
        node.left  = helper(pre, preBeg + 1,       preBeg + len, in, inBeg,   idx - 1);
        node.right = helper(pre, preBeg + len + 1, preEnd,       in, idx + 1, inEnd);
            
        return node;
    }
}