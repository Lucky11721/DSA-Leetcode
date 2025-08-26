class Solution {List<List<Integer>> ans;
    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(nums , list);
        return ans;
    }

    public void helper(int[] arr , List<Integer> list){
        if(list.size() == arr.length){
            ans.add(new ArrayList<>(list));
            return;
        }

        for(int i = 0 ; i < arr.length ; i++){
                    if(list.contains(arr[i]) == false){
                        list.add(arr[i]);
                        
                    helper(arr,list);
                    list.remove(list.size() - 1);
                    }
        }
    }
}