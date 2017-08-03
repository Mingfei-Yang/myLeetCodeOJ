// 106. Construct Binary Tree from In-order and Post-order Traversal
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
 
public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int inLen = inorder.length;
        int postLen = postorder.length;
        
        // Invalid cases
        if (inLen == 0 || postLen == 0 || inLen != postLen) {
            return null;
        }
        
        /* Args: 
           Inorder array, 
           Postorder array, 
           start of inoreder array, 
           end of inorder array, 
           start of postorder array, 
           end of postorder array */
        return treeConstructor(inorder, postorder, 0, inLen - 1, 0, postLen - 1);
    }
    
    private TreeNode treeConstructor(int[] inArr, int[] postArr, int iStart, int iEnd, int pStart, int pEnd) {
        
        if (iStart > iEnd || pStart > pEnd) {
            return null;
        }
        
        // Get the root
        TreeNode root = new TreeNode(postArr[pEnd]);
        
        // Search the root.val in the in-order array
        // And then split the array into two parts
        int i;
        for(i = 0; i <= iEnd; i++) {
            if (inArr[i] == root.val) {
                break;
            }
        }
        
        int iMid = i;  // Break point of In-order array
        int pMid = pEnd - iEnd + i;  // Break point of Post-order array
        
        // Construct left subtree
        root.left = treeConstructor(inArr, postArr, iStart, iMid - 1, pStart, pMid - 1);
        // Construct right subtree
        root.right = treeConstructor(inArr, postArr, iMid + 1, iEnd, pMid, pEnd - 1);
        
        return root;
    }
}
