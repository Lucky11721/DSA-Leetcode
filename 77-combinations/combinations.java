class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> combine(int n, int k) {
        ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(n , k , 1 , list);
        return ans;
    }

    public void helper(int n  , int k , int num, List<Integer> list){
        if(list.size() == k){
            ans.add(new ArrayList<>(list));
            return;
        }
        if(num > n) return;

        list.add(num);
        helper(n , k , num +1 , list);
        list.remove(list.size() -1);
        helper(n , k , num+1 , list);
        
      

    }
}