class Solution {
    public int strStr(String haystack, String needle) {
        char[] arr1= haystack.toCharArray();
        char[] arr2 = needle.toCharArray();
        int n = arr1.length;
        int m =arr2.length;
        int i = 0;

        int count = Integer.MAX_VALUE;
        while(i < n){
            if(arr1[i] == arr2[0]){
                if(check(arr1 , i , arr2 , 0)){
                    count = Math.min(count , i);
                }
            }
            i++;
        }
        if(count == Integer.MAX_VALUE) return -1;

        return count;
     }

    public boolean check(char[] arr1 , int i , char[] arr2 , int j){

        while(i < arr1.length && j < arr2.length){
            if(arr1[i] != arr2[j]){
                return false;
            }
            i++;
            j++;
        }
        if(j < arr2.length ) return false;

        return true;
    }
}
