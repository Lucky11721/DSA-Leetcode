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
   public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                temp.next = list1;
                list1= list1.next;
            }
            else{
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }

        if(list1 == null){
            temp.next = list2;
        }


        if(list2 == null){
            temp.next = list1;
        }

    return dummy.next;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;

        return partitionAndmerge(0 , n-1 , lists);
    }

    public ListNode partitionAndmerge(int start , int end ,ListNode[] lists ){
        if(start > end) return null;
        if(start == end) return lists[start];

        int mid = (start + end)/2;

        ListNode L1 = partitionAndmerge(start , mid , lists);
        ListNode L2  = partitionAndmerge(mid+1 , end , lists);


        return mergeTwoLists(L1 , L2);



    }
}