// 108. Convert Sorted Array to BST
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
    public TreeNode sortedArrayToBST(int[] nums) {
        // Get the length of the array
        int len = nums.length;
        
        if (len == 0) {
            return null;
        }
        
        int left = 0;
        int right = len - 1;
        int mid = left + (right - left) / 2;
        // Root is constructed by the middle value
        TreeNode root = new TreeNode(nums[mid]);
        
        // Split the Array into 2 subarrays from the middle value
        int[] leftArr = new int [mid - left];
        for(int i = 0; i < leftArr.length; i++) {
            leftArr[i] = nums[i];
        }
        
        int[] rightArr = new int [right - mid];
        for(int i = 0; i < rightArr.length; i++) {
            rightArr[i] = nums[i + mid + 1];
        }
        
        // Recursively building BST
        // Use Left part for left subtree, Right part for right subtree
        root.left = sortedArrayToBST(leftArr);
        root.right = sortedArrayToBST(rightArr);
        
        return root;
    }
}
