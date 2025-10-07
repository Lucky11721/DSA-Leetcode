class Solution {
    public int[] avoidFlood(int[] arr) {
        int n = arr.length;   
         HashMap<Integer ,Integer> map = new HashMap<>();
         List<Integer> list = new ArrayList<>();
         int ans[] = new int[n];
         for(int i = 0 ; i < n ; i++){
            if(arr[i] == 0){
                list.add(i);
                ans[i] = 1;
            }
            else{
                ans[i] = -1;
                if(map.containsKey(arr[i])){
                    int flood_index = map.get(arr[i]);
                    int dry = -1;

                    for(int j = 0 ; j< list.size() ; j++){
                        if(list.get(j) > flood_index){
                            dry = j;
                            break;
                        }
                    }

                    if(dry == -1) return new int[0];
                    int dryday = list.get(dry);
                    ans[dryday] = arr[i];
                    list.remove(dry);
                }
                map.put(arr[i] , i);
            }
         }
         return ans;
    }
}