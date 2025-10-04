class Solution {
    public int maxArea(int[] arr) {
        int area = 0;
        int i = 0;
        int j = arr.length-1;

        while(i < j){
            int h = Math.min(arr[i] , arr[j]);
            int l = j-i;

            area = Math.max(area , l*h);
            if(arr[i] >= arr[j]){
                j--;
            }
            else{
                i++;
            }
        }
        return area;
    }
}