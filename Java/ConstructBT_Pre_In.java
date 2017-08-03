// 105. Construct Binary Tree from Preorder and Inorder Traversal

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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preLen = preorder.length;
        int inLen = inorder.length;
        
        // Invalid cases
        if (preLen == 0 || inLen == 0 || preLen != inLen) {
            return null;
        }
        
         /* Args: preArray, inArray, start of preArray, end of preArray, start of inArray, end of inArray */
        return treeConstructor(preorder, inorder, 0, preLen - 1, 0, inLen - 1);
    }
    
    // Constructor method
    /* Args: preArray, inArray, start of preArray, end of preArray, start of inArray, end of inArray */
    private TreeNode treeConstructor(int[] preorder, int[] inorder, int pStart, int pEnd, int iStart, int iEnd) {
        if (pStart > pEnd || iStart > iEnd) {
            return null;
        }
        
        // The first element of preorder array is the root
        TreeNode root = new TreeNode(preorder[pStart]);
        
        // Search the root.val in the inorder array
        // And then split the inorder array into two parts
        int i;
        for(i = iStart; i <= iEnd; i++) {
            if (inorder[i] == root.val) {
                break;
            }
        }
        
        int pMid = pStart + i - iStart;  // Break point of preorder array
        int iMid = i;  // Break point of inorder array
        
        // Left subtree will be constructed using left part of inorder array, and related preorder array
        root.left = treeConstructor(preorder, inorder, pStart + 1, pMid, iStart, iMid - 1);
        // Right subtree will be constructed using right part of inorder array, and related preorder array
        root.right = treeConstructor(preorder, inorder, pMid + 1, pEnd, iMid + 1, iEnd);
        
        return root;
    }
}
