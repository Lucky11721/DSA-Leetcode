class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        ListNode newhead = null;
        ListNode tail = null;

        while (curr != null) {
            // Step 1: Check if there are at least k nodes left
            ListNode check = curr;
            int checkCount = 0;
            while (check != null && checkCount < k) {
                check = check.next;
                checkCount++;
            }

            // If less than k nodes remain, attach the rest as-is and break
            if (checkCount < k) {
                if (tail != null) {
                    tail.next = curr;
                }
                break;
            }

            // Step 2: Reverse k nodes
            ListNode grouphead = curr;
            int count = 0;
            ListNode prev = null;

            while (curr != null && count < k) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
                count++;
            }

            // Step 3: Connect reversed group
            if (newhead == null) {
                newhead = prev;
            }

            if (tail != null) {
                tail.next = prev;
            }

            tail = grouphead;
        }

        return newhead;
    }
}
