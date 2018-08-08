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
    public String tree2str(TreeNode t) {
        if (t == null) return "";
        
        StringBuilder sb = new StringBuilder();
        
        traversal(t, sb);
        
        return sb.toString();
    }
    
    public void traversal(TreeNode node, StringBuilder sb) {
        if (node == null) return;    
        
        sb.append(String.valueOf(node.val));
        
        if (node.left == null && node.right == null) return;
        
        sb.append('(');
        traversal(node.left, sb);
        sb.append(')');
         
        if (node.right != null) {
            sb.append('(');
            traversal(node.right, sb);
            sb.append(')');
        }
    }
}