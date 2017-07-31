// 114. Flatten Binary Tree to Linked List
// Recursive pre-order processing
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
    public void flatten(TreeNode root) {
        
        if (root == null) {
            return;
        }
        
        TreeNode left = root.left;  // Left child
        TreeNode right = root.right;  // Right child
        
        // Process in Pre-order
        root.left = null;          
        flatten(left);
        flatten(right);
        
        // Set the left subtree to right child position
        root.right = left;
        
        // Set the right subtree to the bottom of flattened left subtree
        TreeNode temp = root;
        while (temp.right != null) {
            temp = temp.right;
        }
        
        temp.right = right;
    }
}
