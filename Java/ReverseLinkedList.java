// 206. Reverse Linked List
// Iterative way
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        
        // Invalid case
        if (head == null) {
            return null;
        }
        
        // Single node
        if (head.next == null) {
            return head;
        }
        
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = head.next;
        
        // Iteratively reverse the linked list
        while (next != null) {
            // Set the curr's next to its prev node
            curr.next = prev;
            // Set the prev node to current node
            prev = curr;
            // Move the curr node to its original next node
            curr = next;
            // Move the next node to its next node
            next = next.next;
        }
        
        // Reverse the last node (original tail node)
        curr.next = prev;
        
        // Return the tail node as the new head node
        return curr;
    }
}
