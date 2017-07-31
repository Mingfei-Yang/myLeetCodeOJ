// 129. Sum Root to Leaf Numbers
// Recursive DFS solution
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
    public int sumNumbers(TreeNode root) {
        
        if (root == null) {
            return 0;
        }
        
        return sumCalculator(root, 0);
    }
    
    private int sumCalculator(TreeNode root, int currentSum) {
        // If the node has no children
        if (root.left == null && root.right == null) {
            return currentSum * 10 + root.val;
        }
        
        int s = 0;
        // Left subtree
        if (root.left != null) {
            s += sumCalculator(root.left, currentSum * 10 + root.val);
        }
        // Right subtree
        if (root.right != null) {
            s += sumCalculator(root.right, currentSum * 10 + root.val);
        }
        
        return s;
    }
}
