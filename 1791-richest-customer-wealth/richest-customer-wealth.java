class Solution {
    public int maximumWealth(int[][] accounts) {
        PriorityQueue<Integer> que = new PriorityQueue<>(Collections.reverseOrder()); 
        int n = accounts.length;
        
        for(int i = 0 ; i < n ; i++){
                 int sums = sum(accounts[i]);
                 que.add(sums);
            

        }
         return que.poll();
    }

    public int sum(int[] arr){
             int ans = 0;
             for(int i = 0 ; i < arr.length; i++){
               ans += arr[i];
             }

             return ans;
    }
}