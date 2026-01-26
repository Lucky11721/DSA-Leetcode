class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        int  minDiff = Integer.MAX_VALUE;
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(arr);

        int i = 0 , j = i+1;

        while(j < arr.length ){
            int a = arr[i];
            int b = arr[j];

            int diff = (b - a);
          //  System.out.println(diff + " " + minDiff);
           if( diff < minDiff){
            while(ans.size() > 0){
                ans.remove(ans.size() -1);
            }
            List<Integer> list  = new ArrayList<>();
                list.add(a);
                list.add(b);
                ans.add(list);
                minDiff = diff;
                
            }
             else if(minDiff == diff){
                  List<Integer> list  = new ArrayList<>();
                list.add(a);
                list.add(b);
                ans.add(list);
           }
            i++;
            j++;
           // System.out.println(ans);
        }

        return ans;
    }
}