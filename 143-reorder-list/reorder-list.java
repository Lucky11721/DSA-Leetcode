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

        
        while(head != null){
            head.next = reverse(head.next);
            head = head.next;
        }

    }

    public ListNode reverse(ListNode root){
         
         ListNode pre = null;
         ListNode curr = root;
         while(curr != null){
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
         }

         return pre;
             }
}