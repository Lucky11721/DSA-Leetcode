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
    public ListNode modifiedList(int[] nums, ListNode head) {
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for(int i = 0 ; i < nums.length; i++){
            set.add(nums[i]);
        }
        ListNode temp = head;

        while(temp != null){
            list.add(temp.val);
            temp = temp.next;
        }

        for(int i = 0 ; i < list.size() ; i++){
            if(set.contains(list.get(i))){
                list.set(i , 0);
            }
        }
        ListNode dummy = new ListNode(-1);
        temp = dummy;

        for(int i = 0 ;i < list.size() ; i++){
            if(list.get(i) >  0){
                ListNode temp1 = new ListNode(list.get(i));
                temp.next = temp1;
                temp = temp.next;
            }
        }


        return dummy.next;
        
    }
}