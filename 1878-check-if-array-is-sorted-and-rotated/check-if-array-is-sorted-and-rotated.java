class Solution {
    public boolean check(int[] arr) {
        int n = arr.length;
        boolean sortedCheck = true;

        for(int i = 0 ; i < n -1 ; i++){
            if(arr[i] > arr[i+1]) sortedCheck = false;
        }
        if(sortedCheck == true) return true;
        for(int i = 1 ; i < n ; i++){
            if(arr[i-1] > arr[i]){
                reverse(arr , 0 , i-1);
                reverse(arr , i , n-1);
                break;
            }
        }
        System.out.println(Arrays.toString(arr));
        reverse(arr , 0 , n-1);
        for(int i = 0 ; i < n -1 ; i++){
            if(arr[i] > arr[i+1]){
                return false;
            }
        }

        return true;
    }
    public void reverse(int[] arr , int start , int end){
        while(start <= end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}