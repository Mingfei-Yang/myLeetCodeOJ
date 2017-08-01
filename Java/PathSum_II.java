// 113. Path Sum - II
// Recursive DFS

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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();
        
        // Call DFS func
        /* Args: Tree root, target sum, path list, result list */
        DFSearch(root, sum, path, result);
        
        return result;
    }
    
    private void DFSearch(TreeNode root, int target, List<Integer> path, List<List<Integer>> result) {
        if (root == null) {
            return;
        }
        
        path.add(root.val);  // Add current node value to the path
        
        // If leaf is reached
        if (root.left == null && root.right == null) {
            // If target is met, add current path to result list
            if (root.val == target) {
                result.add(new ArrayList<Integer>(path));
            }
            
            return;
        }
        
        // Visit left subtree
        if (root.left != null) {
            DFSearch(root.left, target - root.val, path, result);
            path.remove(path.size() - 1);
        }
        
        // Visit right subtree
        if (root.right != null) {
            DFSearch(root.right, target - root.val, path, result);
            path.remove(path.size() - 1);
        }
    }
}
