class Solution {
    public int countPartitions(int[] arr) {
        int n = arr.length;

        int[] pre = new int[n];
        pre[0] = arr[0];

        for(int i = 1 ; i < n ; i++){
            pre[i] = arr[i] + pre[i-1];
        }
        
        System.out.println(Arrays.toString(pre));
        int sum = pre[n-1];
        int ans = 0;
        for(int i = 0 ; i < n; i++){
           int leftsum = pre[i];
           int rightsum = sum - pre[i];
           int diff = Math.abs(leftsum - rightsum);
           System.out.println(leftsum + "  " + rightsum + "  " + diff);
           if( diff % 2 == 0){
            ans += 1;
           }
        }

        return ans == 0 ? 0 : ans -1;
    }
}