class Solution {
    public int totalFruit(int[] arr) {
        int n = arr.length;
         HashMap<Integer , Integer> map = new HashMap<>();

         int i = 0;

         int  j =0;

         int ans = 0;

         while(j < n){

            if(map.containsKey(arr[j])){
                int freq = map.get(arr[j]);
                map.put(arr[j] , freq+1);
            }
            else{
                map.put(arr[j] , 1);
            }

            while(map.size() > 2){
                int ele = arr[i];

                map.put(ele , map.get(ele) - 1);
                if(map.get(ele) == 0){
                    map.remove(ele);
                }

                i++;
            }

            ans = Math.max(ans , j - i +1);
            j++;
         }
         return ans;
    }
}