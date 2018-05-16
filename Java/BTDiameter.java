// 543. Diameter of Binary Tree
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
    
    private int max;  // For backtracking, track the maximum depth so far
    
    public int diameterOfBinaryTree(TreeNode root) {
        
        if (root == null) {
            return 0;
        }
        
        // Track the max depth of each node, recursively
        max = 0;
        getMaxDepth(root);
        
        return max - 1;
    }
    
    public int getMaxDepth(TreeNode node) {
        
        // No child
        if (node == null) {
            return 0;
        }
        
        // Has one or more children
        int left = getMaxDepth(node.left);
        int right = getMaxDepth(node.right);
        // Depth at Current node
        int currentDepth = left > right ? left : right;
        // Compare current depth with current maximum depth
        if (left + right + 1 > max)
            max = left + right + 1;  // Update maximum depth so far
        
        return currentDepth + 1;
    }
}
