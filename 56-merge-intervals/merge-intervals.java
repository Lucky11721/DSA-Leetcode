class Solution {
    public int[][] merge(int[][] intervals) {
        List<List<Integer>> list = new ArrayList<>();

        Arrays.sort(intervals , (a,b) -> Integer.compare(a[0],b[0]));

        list.add(new ArrayList<>(Arrays.asList(intervals[0][0], intervals[0][1])));

        int k = 0;

        for(int i = 1 ; i < intervals.length ; i++){
            int start = intervals[i][0];
            int currEnd = intervals[i][1];
            int end = list.get(k).get(1);

            if(end >= start){
                list.get(k).set(1 , Math.max(currEnd , end));
            }
            else{
                List<Integer> currList = new  ArrayList<>();
                currList.add(start);
                currList.add(currEnd);
                list.add(currList);
                k++;
            }
            
        }

        System.out.println(list);

        int[][] ans = new int[list.size()][2];
        int i = 0;
        for(List<Integer> interval : list){
            ans[i][0] = interval.get(0);
            ans[i][1] = interval.get(1);
            i++;
        }
        return ans;

    }
}