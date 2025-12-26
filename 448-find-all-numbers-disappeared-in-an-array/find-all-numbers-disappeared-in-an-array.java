class Solution {
    public List<Integer> findDisappearedNumbers(int[] arr) {
        int n  =arr.length;

        int i = 0 ; 
        while(i < n){
            int ele = arr[i];

            if(ele == i+1 || arr[i] == arr[arr[i]-1]){
                i++;
            }
            else{
                swap(arr ,i , arr[i]-1);
            }
        }
        System.out.println(Arrays.toString(arr));
        
        List<Integer> ans = new ArrayList<>();

        for(i = 0 ; i< n ; i++){
            if(i != arr[i]-1) ans.add(i+1);
        }

        return ans;
    }

    public void swap(int[] arr , int i , int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}