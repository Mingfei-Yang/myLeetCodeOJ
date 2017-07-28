// 24. Swap Nodes in Pairs
// Recursive solution

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        // If no node left or only one node left
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode secondNode = head.next;  // Second node in the pair
        ListNode thirdNode = secondNode.next;  // First node of the next pair
        
        secondNode.next = head;  // Swap the pair
        head.next = swapPairs(thirdNode);  // Recursively swap following node
        
        return secondNode;
    }
}
