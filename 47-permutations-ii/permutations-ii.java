class Solution {
    List<List<Integer>> ans = new ArrayList<>();
     List<Integer> list = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] arr) {

        helper(arr);

        HashSet<List<Integer>> set = new HashSet<>();
        for(int i =  0; i <  ans.size() ; i++){
            set.add(ans.get(i));
        }
        ans.clear();
        for(List<Integer> array : set){
            ans.add(array);
        }
        return ans;
    }

    public void helper(int[] arr){
        if(list.size() == arr.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i = 0; i < arr.length ; i++){
            if(arr[i] != 500){
                int temp = arr[i];
            arr[i] = 500;
            list.add(temp);
            helper(arr);
            arr[i] = temp;
            list.remove(list.size()-1);
            }
        }
    }
}