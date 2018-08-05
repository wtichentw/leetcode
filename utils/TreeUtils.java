public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

// Find LCA of p and q from `node`
public TreeNode LCA(TreeNode node, TreeNode p, TreeNode q) {
    if (node == null) return null;
    if (node == p) return p;
    if (node == q) return q;
        
    TreeNode left  = LCA(node.left, p, q);
    TreeNode right = LCA(node.right, p ,q);
    
    if (left != null && right != null) 
        return node;
    
    if (left != null) 
        return left;    

    if (right != null) 
        return right;
    
    return null;
}
