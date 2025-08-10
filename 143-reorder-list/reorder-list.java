/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        ListNode temp = head;

        while(temp != null){
            ListNode curr = temp.next;
          temp.next = reverseList(curr);
          temp = temp.next;

        }
    }

    public ListNode reverseList(ListNode head){
        ListNode curr = head;
        ListNode nextnode = head;
        ListNode pre = null;

        while(curr != null && nextnode != null){
             nextnode = curr.next;
             curr.next = pre;
             pre = curr;
             curr = nextnode;
        }
        return pre;
    }
}