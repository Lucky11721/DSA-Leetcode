class Solution {
    public int findDuplicate(int[] arr) {
        int slow = 0;
        int fast = 0;

        while(true){
            slow = arr[slow];
            fast = arr[arr[fast]];
            if(slow == fast ) break;
        }

        int slow2 = 0;

        while(true){
            slow = arr[slow];
            slow2 = arr[slow2];
            if(slow == slow2) return slow2;
        }
    }
}