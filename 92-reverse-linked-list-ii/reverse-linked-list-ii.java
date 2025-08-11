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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode left_temp = dummy;

        int l =1;
        while(l < left){
           left_temp = left_temp.next;
           l++;
        }


        ListNode right_temp = dummy;
        int r = 0;
        while(r < right ){
            right_temp = right_temp.next;
            r++;
        }
        ListNode start = left_temp.next;
        left_temp.next = null;
        ListNode remaining = right_temp.next;
        right_temp.next = null;

        ListNode curr = start;
        ListNode nextnode = start;
        ListNode pre = null;

        while(curr != null && nextnode != null){
            nextnode = curr.next;
            curr.next = pre;
            pre = curr;
            curr = nextnode;
        }

        left_temp.next = pre;
        ListNode temp = dummy;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = remaining;

        return dummy.next;
    }
}