class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        for(int[] arr : matrix){
            if(search(arr , 0 , arr.length -1, target)) return true;
        }
        return false;
    }

    public boolean search(int[] arr , int i , int j , int target){

        while(i <= j){
            int mid = i + (j-i)/2;

            if(arr[mid] == target){
                return true;
            }
            else if(arr[mid] > target){
                j = mid -1;
            }
            else{
                i= mid +1;
            }
        }
        return false;
    }
}