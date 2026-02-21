class Solution {
    HashSet<Integer> set = new HashSet<>();
    public int countPrimeSetBits(int left, int right) {
        set.add(2);
        for(int i = 3 ; i <= 32 ; i++){
            if(checkPrime(i)){
                set.add(i);
            }
        }
        int ans = 0;
        for(int x : set){
            System.out.println(x);
        }

        for(int i = left ; i <= right ; i++){
            int countBit = 0;
            int temp = i;
            while(temp > 0 ){
                int bit = temp & 1;
                if(bit == 1) countBit++;
                temp = temp>>1;
            }
            if(set.contains(countBit)) ans++;
        }

        return ans;
    }

    boolean checkPrime(int n){

      int count = 0;
           for(int j = 2 ; j*j<=n; j++){
            if(n%j==0){
                count++;
                break;
            }
           }

           return count == 0 ? true : false;


    }
}