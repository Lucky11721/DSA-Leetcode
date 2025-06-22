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
        if (head == null || head.next == null) return null;

        ListNode slow = head;
        ListNode fast = head;

        // Step 1: Detect cycle using Floyd's algorithm
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // Cycle detected
            if (slow == fast) {
                // Step 2: Find the entry point
                ListNode entry = head;
                while (entry != slow) {
                    entry = entry.next;
                    slow = slow.next;
                }
                return entry;
            }
        }

        // No cycle found
        return null;
    }
}
