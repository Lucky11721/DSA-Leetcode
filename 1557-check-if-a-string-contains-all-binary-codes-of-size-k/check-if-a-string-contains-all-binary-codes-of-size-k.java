class Solution {
    public boolean hasAllCodes(String s, int k) {
        if(k > s.length()) return false;
        
        HashSet<String> set = new HashSet<>();
        int i = 0; 
        int j = k;

        while( j < s.length()){
            String sub = s.substring(i , j);
            set.add(sub);
            j++;
            i++;
        }
        set.add(s.substring(i,j));
        int temp = 0;
         StringBuilder sb = new StringBuilder();
        for(int x = 0 ; x < k ; x++){
            sb.append('0');
        }
        System.out.println(sb);

        int K = 0;
      K = (1 << k) - 1;
        System.out.println(Integer.toBinaryString(K));
        System.out.println(K);
        while( temp <= K){

            int index = sb.length() -1;

            int num = temp;
            while(num > 0){
                if((num & 1) == 1 ){
                    sb.setCharAt(index , '1');
                }
                else {
                    sb.setCharAt(index, '0'); 
                }
                num = num >> 1;
                index--;
            }

            if(set.contains(sb.toString()) == false) return false;
            

            temp++;
        }



        return true;
    }
}