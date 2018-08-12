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
    public boolean isSymmetric(TreeNode root) {
        return root == null ? true : compare(root.left, root.right);
    }
    
    public boolean compare(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        
        boolean s1 = (t1.val == t2.val);
        boolean s2 = compare(t1.right, t2.left);
        boolean s3 = compare(t1.left , t2.right);
        
        return s1 && s2 && s3;
    }
}