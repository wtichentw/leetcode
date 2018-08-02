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
    public int findBottomLeftValue(TreeNode root) {
        // lvl, val
        int[] res = new int[2];
        res[0] = -1;
        res[1] = Integer.MIN_VALUE;
        
        traversal(root, 0, res);
        
        return res[1];
    }
    
    public void traversal(TreeNode root, int lvl, int[] res) {
        if (root == null) 
            return;
        
        if (lvl > res[0]) {
            res[0] = lvl;
            res[1] = root.val;
        }
            
        traversal(root.left,  lvl + 1, res);
        traversal(root.right, lvl + 1, res);
    }
}