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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode groupprev = dummy;

        while(true){
              ListNode kthNode = getkth(groupprev , k);
              if(kthNode == null){
                break;
              }

              ListNode grouphead = groupprev.next;
              ListNode groupnext = kthNode.next;
              ListNode curr = grouphead;
              ListNode pre = kthNode.next;
              while(curr != groupnext){
                  ListNode nextNode = curr.next;
                  curr.next = pre;
                  pre = curr;
                  curr = nextNode;
              }

             ListNode temp = groupprev.next;
             groupprev.next = kthNode;
             groupprev = temp;


        }
        return dummy.next;
    }

    public ListNode getkth(ListNode head , int k){
         ListNode curr = head;

         while(curr != null && k > 0){
            curr = curr.next;
            k--;
         }
         return curr;
    }

}