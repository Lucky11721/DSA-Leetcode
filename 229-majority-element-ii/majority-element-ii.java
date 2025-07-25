class Solution {
    public List<Integer> majorityElement(int[] arr) {
        int n = arr.length;
         List<Integer> ans = new ArrayList<>();
         HashSet<Integer> set= new HashSet<>();
         for(int i = 0 ; i < n ; i++){
            int count = 1;
            for(int j = i+1 ; j < n ;j++){
                if(arr[i] == arr[j]){
                    count++;
                }
            }
            if(count > n/3){
                set.add(arr[i]);
            }
         }
         for(int ele : set){
            ans.add(ele);
         }
         return ans;
    }
}