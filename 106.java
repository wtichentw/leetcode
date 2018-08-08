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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
    
    public TreeNode helper(int[] in, int inLow, int inHigh, int[] post, int postLow, int postHigh) {
        if (inLow > inHigh || postLow > postHigh) return null;
        
        TreeNode node = new TreeNode(post[postHigh]);
        
        int idx = 0;
        for (idx = inLow; idx <= inHigh; idx++) {
            if (in[idx] == node.val) break;
        }
        
        // left len
        int len = idx - inLow;
            
        node.left = helper(in, inLow, idx - 1, post, postLow, postLow + len - 1);
        node.right = helper(in, idx + 1, inHigh, post, postLow + len, postHigh - 1);
        
        return node;
    }
}