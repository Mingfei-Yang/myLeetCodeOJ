// 617. Merge Two Binary Trees

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
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        TreeNode nNode;
        
        if (t1 != null && t2 != null) {
            // Both trees are not null
            nNode = new TreeNode(t1.val + t2.val);
            nNode.left = mergeTrees(t1.left, t2.left);
            nNode.right = mergeTrees(t1.right, t2.right);
        }
        else if (t1 != null && t2 == null) {
            // t2 is null
            nNode = new TreeNode(t1.val);
            nNode.left = mergeTrees(t1.left, null);
            nNode.right = mergeTrees(t1.right, null);
        }
        else if (t1 == null && t2 != null) {
            // t1 is null
            nNode = new TreeNode(t2.val);
            nNode.left = mergeTrees(null, t2.left);
            nNode.right = mergeTrees(null, t2.right);
        }
        else {
            // Both are null, return null
            return null;
        }

        return nNode;
    }
}
