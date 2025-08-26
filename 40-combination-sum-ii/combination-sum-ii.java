class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        System.out.println(Arrays.toString(candidates));

        List<Integer> list  = new ArrayList<>();
        helper(candidates , 0 , list ,target);
        return ans;
    }
    public void helper(int[] arr , int index ,  List<Integer> list , int target){
         if(target == 0 && ans.contains(list) == false){
            ans.add(new ArrayList<>(list));
            return;
        }
         if(  index == arr.length || target < 0) return;
        list.add(arr[index]);
        helper(arr , index+1 , list , target - arr[index]);
        list.remove(list.size() -1);
          int next = index + 1;
        while (next < arr.length && arr[next] == arr[index]) {
            next++;
        }
        helper(arr, next, list, target);
    }
}