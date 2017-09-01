// 226. Invert Binary Tree
// Recursive Solution

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
    public TreeNode invertTree(TreeNode root) {
        
        // The inversion of an empty tree is empty
        if (root == null) {
            return null;
        }
        
        // Invert the left and right subtree, then swap them
        TreeNode lSub = invertTree(root.left);
        TreeNode rSub = invertTree(root.right);
        
        root.left = rSub;
        root.right = lSub;
        
        return root;
    }
}
