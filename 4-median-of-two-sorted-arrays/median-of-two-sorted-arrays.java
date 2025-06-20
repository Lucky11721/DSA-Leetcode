class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {


        int m = nums1.length;
        int n = nums2.length;

        int ans[] = new int[m+n];
        merge(nums1 , nums2 , ans);
        int prefixsum = 0;
        for(int i =0 ; i < ans.length; i++){
            prefixsum += ans[i];
        }
       if((m+n) % 2 == 1){
        return (double)ans[(m+n)/2];
       }
       else{
        return  ((double)ans[(m+n)/2 -1] +  (double)ans[(m+n)/2]) /2;
       }

    }

    public void merge(int[] nums1 , int[] nums2 , int[] ans){

        int i = 0;
        int j = 0;
        int k  =0 ;
     while(i < nums1.length && j < nums2.length){
        if(nums1[i] < nums2[j]){
            ans[k] = nums1[i];
            i++;
            k++;
        }
        else{
            ans[k] = nums2[j];
            j++;
            k++;
        }
     }
    
    if(i == nums1.length){
        while(j < nums2.length){
            ans[k] = nums2[j];
            j++;
            k++;
        }
    }
    if(j == nums2.length){
        while(i < nums1.length){
            ans[k] = nums1[i];
            i++;
            k++;
        }
    }


    }
}