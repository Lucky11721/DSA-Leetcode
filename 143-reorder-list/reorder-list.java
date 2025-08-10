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
        

        ListNode slow = head;
        ListNode fast = head.next;

        while(fast!= null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode firsthalf = head;
        ListNode secondhalf = slow.next;
        slow.next = null;
       secondhalf =  reverse(secondhalf);
        ListNode l1 = firsthalf;
        ListNode l2 = secondhalf;

        while( l1 != null && l2 != null){
   ListNode temp1 = l1.next;
   ListNode temp2 = l2.next;

   l1.next = l2;
   l2.next = temp1;
   l1 = temp1;
   l2 = temp2;
   
        }
   
    }

    public ListNode reverse(ListNode head){
        ListNode curr =head;
        ListNode pre = null;
        ListNode nextnode = head;

        while(curr != null && nextnode != null){
            nextnode = curr.next;
            curr.next =pre;
            pre = curr;
            curr = nextnode;
        }
        return pre;
    }
}