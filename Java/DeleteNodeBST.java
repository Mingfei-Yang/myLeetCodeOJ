// 450. Delete Node in a BST
// Iterative way

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
    public TreeNode deleteNode(TreeNode root, int key) {
        // Search the node first
        TreeNode node = root;
        TreeNode parent = null;  // the parent of the deleted node
        
        while (node != null) {
            // If current value > key, then search left subtree
            if (node.val > key) {
                parent = node;
                node = node.left;
            }
            // If current value < key, then search right subtree
            else if (node.val < key) {
                parent = node;
                node = node.right;
            }
            // If equal then break;
            else {
                break;
            }
        }
        
        // If the node is root
        if (parent == null) {
            return deleteNode(node);
        }

        if (parent.left == node) {
            sbtParent.left = deleteNode(node);
        }
        
        else {
            parent.right = deleteNode(node);
        }
        
        return root;
    }
    
    private TreeNode deleteNode(TreeNode root) {
        
        if (root == null) {
            return null;
        }
        
        // Single Child
        if (root.left == null) {
            return root.right;
        }
        
        if (root.right == null) {
            return root.left;
        }
        
        // Two children
        TreeNode prevNode = null;
        TreeNode nextNode = root.right;
        
        // Get the successor, it must be the minimum node in its right subtree
        while (nextNode.left != null) {
            prevNode = nextNode;
            nextNode = nextNode.left;
        }
        
        nextNode.left = root.left;
        
        if (root.right != nextNode) {
            prevNode.left = nextNode.right;
            nextNode.right = root.right;
        }
        
        return nextNode;
    }
}
