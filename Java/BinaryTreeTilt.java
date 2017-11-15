// 563. Binary Tree Tilt
// Recursive, Post-order Traversal
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
    
    private int tilt = 0;  // Track the tilt
    
    public int findTilt(TreeNode root) {
        // Recursive solution
        recursiveSolution(root);
        
        return tilt;
    }
    
    private int recursiveSolution(TreeNode root) {
        
        if (root == null) {
            return 0;
        }
        
        // Get the left subtree sum, get the right subtree sum
        int left = recursiveSolution(root.left);
        int right = recursiveSolution(root.right);

        // Track the tilt as well
        tilt += Math.abs(left - right);
                
        // Sum them together with root.val
        // Get the sum of this tree - with "root" as root
        return left + right + root.val;
    }
}
