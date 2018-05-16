// 101. Symmetric Tree
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
class Solution {
    public boolean isSymmetric(TreeNode root) {
        // Recursive solution
        return subSymmetric(root, root);
    }
    
    public boolean subSymmetric(TreeNode left, TreeNode right) {
        // Both are null - true
        if (left == null && right == null) {
            return true;
        }
        // Either one is null - false
        if (left == null || right == null) {
            return false;
        }
        
        // Check whether left.val == right.val
        // And whether left.left == right.right && left.right == right.left
        return (left.val == right.val) && subSymmetric(left.left, right.right) && subSymmetric(left.right, right.left);
    }
}
