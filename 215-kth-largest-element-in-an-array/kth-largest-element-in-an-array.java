class Solution {
    public int findKthLargest(int[] arr, int k) {
        PriorityQueue<Integer> que = new PriorityQueue<>();
      int n = arr.length;
        for(int i = 0 ; i < n  ; i++){
           que.add(arr[i]);

           if(que.size() > k){
            que.poll();
           }
        }

        int ans = que.poll();
return ans;
    }
}