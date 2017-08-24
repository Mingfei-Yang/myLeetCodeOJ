// 142. Linked List Cycle - II
// Two pointers, fast & slow

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        
        // 2 pointers, slow & fast
        ListNode slowPointer = head;
        ListNode fastPointer = head;
        
        while (fastPointer.next != null && fastPointer.next.next != null) {
            // slowPointer moves 1 step each iteration
            slowPointer = slowPointer.next;
            // fastPointer moves 2 steps each iteration
            fastPointer = fastPointer.next.next;
            
            // If slow meets fast, then the cycle exists
            if (slowPointer == fastPointer) {
                // New node that moves from head to find the beginning of the cycle
                ListNode t = head;
                
                // While t != slowPointer, each of them moves 1 step
                // Eventually after moving same steps, 
                // they will meet at the start node of the cycle
                while (t != slowPointer) {
                    slowPointer = slowPointer.next;
                    t = t.next;
                }
                
                return t;
            }
        }
        
        return null;
    }
}
