class Solution {
    public int minimumTeachings(int k, int[][] lan, int[][] friend) {
        
        int n = lan.length;
        int m = friend.length;

        HashSet<Integer> set = new HashSet<>();

        for(int i = 0 ; i < m ; i++){
            int u = friend[i][0] -1;
            int v = friend[i][1] -1;
            
            HashSet<Integer> temp = new HashSet<>();
            for(int j= 0 ; j < lan[u].length; j++){
                     temp.add(lan[u][j]);
            }

            boolean flag = false;
            for(int j = 0 ; j < lan[v].length ; j++){
                if(temp.contains(lan[v][j])){
                    flag = true;
                    break;
                }
            }
           
           if(flag == false){
             set.add(u);
             set.add(v);
           }
           
        }

        System.out.println(set);

        int[] langknown = new int[k+1];

        for(int ele : set){
            for(int j = 0 ; j < lan[ele].length ; j++ ){
                int lang = lan[ele][j];
                langknown[lang] += 1;
            }
        }

        int max = 0;

        for(int i = 0 ; i < langknown.length ; i++){
             max = Math.max(langknown[i] , max);
        }
        System.out.println(max);
        int ans = set.size() - max;

        return ans;
    }
}