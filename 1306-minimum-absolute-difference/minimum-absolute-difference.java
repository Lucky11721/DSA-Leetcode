class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        int n = arr.length;
        int  minDiff = Integer.MAX_VALUE;
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(arr);

        for(int i = 1 ; i < n ; i++){
            int a = arr[i-1];
            int b = arr[i];

            minDiff = Math.min(minDiff , b-a);
        }

        for(int i = 1 ; i < n ; i++){
             int a = arr[i-1];
            int b = arr[i];
            int diff = b-a;
            if(diff == minDiff){
                 ans.add(new ArrayList<>(Arrays.asList(a, b)));
            }
        }
      
        return ans;
    }
}