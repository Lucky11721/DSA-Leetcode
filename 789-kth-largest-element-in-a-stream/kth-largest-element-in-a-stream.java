class KthLargest {
  PriorityQueue<Integer> que = new PriorityQueue<>();
  int K;
    public KthLargest(int k, int[] nums) {
        K = k;
        for(int  i = 0 ; i <  nums.length ; i++){
            que.add(nums[i]);
            if(que.size() > k ){
                que.poll();
            }
        }
    }
    
    public int add(int val) {
       int ans = 0;
       if(que.size() < K){
         que.add(val);
       }
       else{
         que.add(val);
         que.poll();
       }
       ans = que.peek();
       return ans;
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */