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

        ListNode temp = head;
        ListNode a = null;
        ListNode b = null;
        ListNode c = null;
        ListNode d = null;

        int position =1;
        while(temp != null){
            if(position == left -1){
                a = temp;
            }
            if(position == left){
                b = temp;
            }
            if(position == right){
                c = temp;
            }
            if(position == right+1){
                d = temp;
            }

            temp = temp.next;
            position++;
        }

        if(a != null) a.next = null;
        if(c != null) c.next = null;
       
         temp = b;
        ListNode curr = temp;
        ListNode pre  = null;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }

      if(a!=null) a.next = c;
       b.next =d;
       if(a==null){
            return c;
        }

        return head;

    }
}