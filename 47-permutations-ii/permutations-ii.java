class Solution {
     HashMap<Integer,Integer> map = new HashMap<>();
     List<List<Integer>> ans = new ArrayList<>();
     List<Integer> list = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {


        for(int ele : nums){
            if(map.containsKey(ele)){
                map.put(ele , map.get(ele)+1);
            }
            else{
                map.put(ele , 1);
            }
        }
        helper(nums );

     return ans;
    }
    
    public void helper(int[] arr){
        if(list.size() == arr.length){
            ans.add(new ArrayList<>(list));
            return;
        }

        for(int key : map.keySet()){
            if(map.get(key) == 0 ) continue;
            if(map.get(key) > 0){
                list.add(key);
                map.put(key , map.get(key) -1);

                helper(arr);

                list.remove(list.size() - 1);
                map.put(key , map.get(key) +1);
            }
        }
    }
    }