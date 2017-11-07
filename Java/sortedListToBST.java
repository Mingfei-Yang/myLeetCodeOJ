// 109. Convert Sorted List to BST
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        
        if (head == null) {
            return null;
        }
        
        /** Pick the middle node of the linked list as tree root
         * Then split the List into 2 parts from the MidNode
         * Then recursively build left subtree and right subtree
         * To Split, simply Cut at the Middle Node 
         */
        
        // Use slow and fast to get the Cut point and middle node(slow)
        ListNode slow = head;
        ListNode fast = head;
        ListNode cutNode = null;
        
        // Get Cutting Node and Middle Node
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            cutNode = slow;
            slow = slow.next;
        }

        // Cutting by setting its next to NULL
        if (cutNode == null) {
            head = null;
        }
        else {
            cutNode.next = null;
        }
        
        TreeNode root = new TreeNode(slow.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);
        
        return root;
    }
}
