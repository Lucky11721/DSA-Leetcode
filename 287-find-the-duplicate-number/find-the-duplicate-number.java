class Solution {
    public int findDuplicate(int[] arr) {
        int n = arr.length;

        HashSet<Integer> set = new HashSet<>();
        int ans = 0;
        for(int  i = 0 ; i < n ;i++){
             if(set.contains(arr[i])){
                ans = arr[i];
                break;
             }
              set.add(arr[i]);
        }
        return ans;
    }
}