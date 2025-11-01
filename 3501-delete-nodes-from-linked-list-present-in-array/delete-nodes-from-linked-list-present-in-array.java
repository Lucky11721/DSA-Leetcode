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

        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        ListNode curr = head;

        while(curr != null){
            if(set.contains(curr.val)){
                temp.next = curr.next;
            }
            else{
                 temp.next = curr;
                 temp = curr;
            }
            curr = curr.next;
        }

        return dummy.next;
        
    }
}