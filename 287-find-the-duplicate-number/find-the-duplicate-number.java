class Solution {
    public int findDuplicate(int[] arr) {
        int n = arr.length;

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i = 0 ; i <  n  ;i++){
            int ele = arr[i];

            if(map.containsKey(ele)){
                int freq = map.get(ele);
                map.put(ele , freq+1);
            }
            else{
                map.put(ele ,1);
            }

              if(map.get(ele) > 1){
                return ele;
            }
        }
        return -1;
    }
}