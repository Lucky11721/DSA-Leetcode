class Solution {
    int[] ans;
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        ans = new int[n];
        Arrays.sort(potions);

        for(int i = 0 ; i  < n ; i++){
            long minpotion = (long)Math.ceil(((double)success)/spells[i]);
            System.out.println(minpotion);
            ans[i] = binarySearch(minpotion , potions);
        }
        return ans;
    }

    public int binarySearch(long target , int[] arr){
        
        int i = 0;
        int j = arr.length-1;
if(arr[j] < target) return 0;

        int index = j+1;
        while(i <= j){

            int mid = i + (j-i)/2;

            if(arr[mid] >= target){
                index = mid;
                j = mid-1;
            }
            else{
                i = mid+1;
            }
        }

        return arr.length - index;
    }
}