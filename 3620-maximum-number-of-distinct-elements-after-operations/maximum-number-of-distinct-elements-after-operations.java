class Solution {
    public int maxDistinctElements(int[] arr, int k) {
        Arrays.sort(arr);
        int n = arr.length;

        int count = 0;
        int current = Integer.MIN_VALUE;
        for(int ele : arr){
            int low = ele -k;
            int high = ele + k;

            if(current + 1 <= high){
                int assign = Math.max(current +1 , low);
                current = assign;
                count++;
            }


        }

        return count;
    }

}
