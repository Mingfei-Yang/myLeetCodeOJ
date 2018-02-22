// 617. Merge Two Binary Trees
// Recursive way

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
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        
        // If t1 and t2 are NULL
        if (t1 == null && t2 == null) {
            return null;
        }
        // t2 == null, return t1
        else if (t1 != null && t2 == null) {
            return t1;
        }
        // t1 == null, return t2
        else if (t1 == null && t2 != null) {
            return t2;
        }
        // Both are NOT NULL
        // Merge trees Recursively
        else {
            int val_t1 = t1 == null ? 0 : t1.val;
            int val_t2 = t2 == null ? 0 : t2.val;
        
            TreeNode root = new TreeNode(val_t1 + val_t2);
            root.left = mergeTrees(t1.left, t2.left);
            root.right = mergeTrees(t1.right, t2.right);
        
            return root;
        }
        
        
    }
}
