class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        // 1️⃣ Count nodes
        int n = 0;
        ListNode temp = head;
        while (temp != null) {
            n++;
            temp = temp.next;
        }

        // 2️⃣ Move temp pointer to the middle
        int mid = n / 2;
        ListNode firstHalfEnd = head;
        for (int i = 1; i < mid; i++) {
            firstHalfEnd = firstHalfEnd.next;
        }

        // 3️⃣ Split list into two halves
        ListNode secondHalf = firstHalfEnd.next;
        firstHalfEnd.next = null;

        // 4️⃣ Reverse second half
        secondHalf = reverseList(secondHalf);

        // 5️⃣ Merge halves
        ListNode p1 = head;
        ListNode p2 = secondHalf;
        while (p1 != null && p2 != null) {
            ListNode next1 = p1.next;
            ListNode next2 = p2.next;

            p1.next = p2;
            if (next1 == null) break; // Handles odd length
            p2.next = next1;

            p1 = next1;
            p2 = next2;
        }
    }

    // Helper: reverse a linked list
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
