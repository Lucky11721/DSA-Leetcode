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
    public ListNode mergeKLists(ListNode[] lists) {
        List<Integer> list = new ArrayList<>();
        for(int i =0 ; i < lists.length ; i++){
            while(lists[i] != null){
                list.add(lists[i].val);
                lists[i] = lists[i].next;
            }
        }

        Collections.sort(list);

        ListNode ans = new ListNode(-1);

        ListNode temp = ans;

        for(int num : list){
            temp.next = new ListNode(num);
            temp = temp.next;
        }

        return ans.next;

    }
}