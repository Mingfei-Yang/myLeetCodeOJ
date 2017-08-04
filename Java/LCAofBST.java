// 235. Lowest Common Ancestor of a Binary Search Tree
// Recursive solution
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        // If p.val < root.val && q.val < root.val
        // Find LCA in left subtree
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        // If p.val > root.val && q.val > root.val
        // Find LCA in right subtree
        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        
        // If p.val <= root.val <= q.val or q.val <= root.val <= p.val
        // The LCA is the root
        return root;
    }
}
