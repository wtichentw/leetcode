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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }
    
    public TreeNode helper(int[] nums, int l, int r) {
        // terminal
        if (l > r) return null;
        if (l == r) return new TreeNode(nums[l]);
        
        // find max and divide and conquer
        int max = nums[l], idx = l;
        for (int i = l; i <= r; i++) {
            if (nums[i] > max) {
                max = nums[i];
                idx = i;
            }
        }
        
        TreeNode root = new TreeNode(nums[idx]);
        root.left = helper(nums, l, idx - 1);
        root.right = helper(nums, idx + 1, r);
        
        return root;
    }
}