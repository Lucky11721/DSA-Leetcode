class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> set = new HashSet<>();

        for(int i = 0 ; i < nums1.length ; i++){
            set.add(nums1[i]);
        }
        Set<Integer> ans = new HashSet<>();
        for(int i =  0 ; i < nums2.length ; i++){
            if(set.contains(nums2[i])){
                ans.add(nums2[i]);
            }
        }

        int[] arr =  new int[ans.size()];
        int i = 0;
        for(int val : ans){
            arr[i] = val;
            i++;
        }
        return arr;
    } 
}