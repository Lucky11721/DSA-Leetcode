class Solution {
    public int[] avoidFlood(int[] arr) {
        int n = arr.length;   
         HashMap<Integer ,Integer> map = new HashMap<>();
         TreeSet<Integer> set = new TreeSet<>();
         int ans[] = new int[n];
         for(int i = 0 ; i < n ; i++){
            if(arr[i] == 0){
                set.add(i);
                ans[i] = 1;
            }
            else{
                ans[i] = -1;
                if(map.containsKey(arr[i])){
                    int flood_index = map.get(arr[i]);
                    Integer dry = set.higher(flood_index);
                    if(dry == null) return new int[0];
        
                    ans[dry] = arr[i];
                    set.remove(dry);
                }
                map.put(arr[i] , i);
            }
         }
         return ans;
    }
}