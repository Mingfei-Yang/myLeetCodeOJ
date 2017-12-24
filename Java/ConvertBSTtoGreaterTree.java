// 538. Convert BST to Greater Tree
// Recursive solution - Reverse In-Order Traversal
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
    
    // Global sum
    private int sum = 0;
    
    public TreeNode convertBST(TreeNode root) {
        // Not null
        if (root != null) {
            // Reverse In-order Recursion
            // Right Child - Node - Left Child
            // Right
            convertBST(root.right);
            
            // Root
            // Update sum
            sum += root.val;
            // Update the value of the node
            root.val = sum;
            
            // Left
            convertBST(root.left);
        }
        
        return root;
    }
}
