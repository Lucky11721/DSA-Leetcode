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
       if(sum % 2 == 0) return n-1;
       return 0;
    }
}