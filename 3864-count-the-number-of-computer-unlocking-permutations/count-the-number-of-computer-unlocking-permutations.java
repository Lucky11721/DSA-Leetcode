class Solution {
    int MOD = 1000000007;
    public int countPermutations(int[] arr) {
        int n  = arr.length;
        int unlock = arr[0];
        for(int i =1 ; i < n ; i++ ){
            if(arr[i] <= unlock) return 0;
        }
       long fact = 1L;
        for (int i = 1; i <= n - 1; i++) {
            fact = (fact * i) % MOD;
        }
        return (int) fact;
    }
}