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
    public TreeNode str2tree(String s) {
        if (s.length() == 0) return null;
        
        int[] idx = new int[] { 0 };
        
        return traversal(s, idx);
    }
    
    public TreeNode traversal(String s, int[] idx) {
        if (idx[0] == s.length()) return null;
        
        int num = 0, sign = 1;
        
        // parse sign
        if (s.charAt(idx[0]) == '-') {
            sign = -1;
            idx[0]++;
        }
        
        // parse number
        while (idx[0] < s.length() && Character.isDigit(s.charAt(idx[0]))) {
            num = num * 10 + (s.charAt(idx[0]) - '0');
            idx[0]++;
        }
        
        TreeNode node = new TreeNode(num * sign);
        
        // try left
        if (idx[0] < s.length() && s.charAt(idx[0]) == '(') {
            idx[0]++;
            node.left = traversal(s, idx);
        } 

        // try right
        if (idx[0] < s.length() && s.charAt(idx[0]) == '(') {
            idx[0]++;
            node.right = traversal(s, idx);
        }
        
        // omit ending
        if (idx[0] < s.length() && s.charAt(idx[0]) == ')') {
            idx[0]++;
        }
       
        return node;
    }
}