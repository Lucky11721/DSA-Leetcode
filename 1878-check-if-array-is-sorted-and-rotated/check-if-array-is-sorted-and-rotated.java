class Solution {
    public boolean check(int[] arr) {
        int n = arr.length;
        int rotate = 0;

        for(int i = 0 ; i < n-1  ; i++){
            if(arr[i] > arr[i+1]){
                rotate++;
            }
        }

        System.out.println(rotate);
        if(arr[n-1] > arr[0]) rotate++;
        if(rotate <= 1) return true;

        return false;
    }
}