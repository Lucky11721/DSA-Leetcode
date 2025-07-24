class Solution {
    public void sortColors(int[] arr) {
        int n = arr.length;

        int i = 0;
        int j = n-1;
        int mid = 0;


        while(mid  <= j){
            if(arr[mid] == 0){
                swap(arr , i , mid);
                mid++;
                i++;
            }
            else if(arr[mid] == 2){
                  swap(arr , mid,j);
                  j--;
            }
            else{
                mid++;
                
            }
        }
    }
    public void swap(int[] arr , int i , int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}