class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(nums , list , 0);
        return ans;
    }

    public void helper(int[] arr , List<Integer> list , int index){
        if(list.size() == arr.length){
            ans.add(new ArrayList<>(list));
            return;
        }

        for(int i = index ; i < arr.length ; i++){
                swap(arr, i , index);
                list.add(arr[index]);
                helper(arr , list , index +1 );
                swap(arr , i , index);
               list.remove(list.size() -1);
                    }    
    }
    public void swap( int[] arr,int i , int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}