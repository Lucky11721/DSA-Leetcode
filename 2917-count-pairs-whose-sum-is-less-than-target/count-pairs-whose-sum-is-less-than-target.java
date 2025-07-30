class Solution {
    public int countPairs(List<Integer> arr, int target) {
        Collections.sort(arr);
        int n = arr.size();
        int i = 0;
        int j = n-1;
        int ans = 0;

        while(i < j){
            int sum = arr.get(i) + arr.get(j);

            if(sum < target){
                ans += j - i;
                i++;            
            }
            else{
            j--;
        }
    }
    return ans;
}
}