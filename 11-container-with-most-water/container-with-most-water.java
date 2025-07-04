class Solution {
    public int maxArea(int[] arr) {
        int n = arr.length;

        int i  =0; 
        int j = n-1;

        int ans = Integer.MIN_VALUE;

        while(i < j){
            int h = Math.min(arr[i] , arr[j]);
            int l = j-i;

            int area = h * l;

            ans = Math.max(area , ans);


            if(arr[i] < arr[j]){
                i++;
            }
            else{
                j--;
            }


        }
        return ans;
    }
}