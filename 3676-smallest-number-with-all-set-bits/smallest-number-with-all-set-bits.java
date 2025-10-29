class Solution {
    public int smallestNumber(int n) {
        int size = 0;
        int temp  = n;
        while(temp > 0){
            size++;
            temp = temp>>1;
        }
        System.out.println(size);
        int[] set_bit = new int[size];
        int num = size-1;
        for(int i = num ; i >= 0 ; i--){
            set_bit[i] = 1;
        }
         System.out.println(Arrays.toString(set_bit));

        int ans = 0;
        int power = 0;
          for(int i = num ; i >= 0 ; i--){
            ans += Math.pow(2 , power) *set_bit[i];
            power++;
        }

        return ans;
    }
}