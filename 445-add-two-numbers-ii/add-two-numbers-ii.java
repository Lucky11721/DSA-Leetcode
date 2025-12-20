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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode list1 = reverse(l1);
        ListNode list2 = reverse(l2);

        int carry = 0;

        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while(list1 != null && list2 != null){

            int a = list1.val;
            int b = list2.val;
            int sum = a+b +carry;

            ListNode node = new ListNode(sum%10);

            temp.next = node;
            if(sum >= 10){
                carry = 1;
            }
            else{
                carry = 0;
            }

            list1 = list1.next;
            list2 = list2.next;
            temp = temp.next;

        }
        
        

        while(list1 != null){
            if(carry == 1){
                int sum = list1.val + carry;
                ListNode node = new ListNode(sum %10);
                temp.next = node;
                list1 = list1.next;
                temp = temp.next;
                if(sum >= 10){
                    carry = 1;
                }
                else{
                    carry = 0;
                }
            }
            else{
                temp.next = list1;
                break;
            }
        }
         while(list2 != null){
            if(carry == 1){
                int sum = list2.val + carry;
                ListNode node = new ListNode(sum %10);
                temp.next = node;
                list2 = list2.next;
                temp = temp.next;
                if(sum >= 10){
                    carry = 1;
                }
                else{
                    carry = 0;
                }
            }
            else{
                temp.next = list2;
                break;
            }
        }

        if(carry == 1){
            ListNode node = new ListNode(1);
            temp.next = node;
        }
ListNode ans = dummy.next;
        return reverse(ans);
    }

    public ListNode reverse(ListNode list){

        ListNode prev = null;
        ListNode curr = list;

        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}