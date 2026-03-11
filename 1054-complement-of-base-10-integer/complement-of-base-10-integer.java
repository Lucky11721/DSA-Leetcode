class Solution {
    public int bitwiseComplement(int n) {
        
        char[] ch  = Integer.toBinaryString(n).toCharArray();


        for(int i  = 0 ; i < ch.length ; i++){
            if(ch[i] == '0') ch[i] = '1';
            else ch[i] = '0';
        }
        System.out.println(Arrays.toString(ch));
        int num = 0;
        int power = 0;

        for(int i = ch.length -1 ; i >= 0 ; i-- ){
            System.out.println(ch[i] - '0');
           
            num += Math.pow(2 , power) * (ch[i] -'0');
            power++;
        }

        return num;
    }
}