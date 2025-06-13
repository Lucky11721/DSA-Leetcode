class Solution {
    public int singleNonDuplicate(int[] arr) {
        HashMap<Integer , Integer> map = new HashMap<>();


        for(int num : arr){

            if(map.containsKey(num)){
                int freq = map.get(num);
                map.put(num , freq +1);
            }
            else{
                map.put(num , 1);
            }
        }

        for(int ele : arr){
            if(map.get(ele) == 1) return ele;
        }

        return -1;
    }
}