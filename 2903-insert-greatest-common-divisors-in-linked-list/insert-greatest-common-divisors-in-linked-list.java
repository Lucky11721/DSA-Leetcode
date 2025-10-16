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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if(head.next == null) return head;
        ListNode a = head;
        ListNode b = head.next;
        while(b.next != null){
            ListNode gcd = new ListNode(hcf(a.val , b.val));
            a.next= null;
            gcd.next = b;
            a.next = gcd;
            a = gcd.next;
            b = b.next;
        }
         ListNode gcd = new ListNode(hcf(a.val , b.val));
            a.next= null;
            gcd.next = b;
            a.next = gcd;
            a = gcd.next;
            b = b.next;
        return head;
    }


    public int hcf(int a , int b){
         while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}