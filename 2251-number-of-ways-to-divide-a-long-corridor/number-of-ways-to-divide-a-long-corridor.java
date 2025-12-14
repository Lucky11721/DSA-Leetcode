class Solution {

    public int numberOfWays(String corridor) {
        int n = corridor.length();
        int MOD = 1000000007;
        List<Integer> list = new ArrayList<>();
        int count = 0;
        for(int i = 0 ; i < n ; i++){
            if(corridor.charAt(i) == 'S'){
                list.add(i);
                count++;
            }
        }
        if(count == 0 || count %2 != 0) {
            return 0;
        }


        int prev_end = list.get(1);
        long ans = 1;
        for(int i = 2 ; i < list.size() ; i  =i+2){
            int length = list.get(i) - prev_end ;
             ans = (ans * length)  % MOD;
            prev_end  = list.get(i+1);
            
        }

        return (int)ans % MOD;
    }
}