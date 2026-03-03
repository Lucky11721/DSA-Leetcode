class Solution {
    public char findKthBit(int n, int k) {
        String str = "0";
       StringBuilder sb = new StringBuilder(str);

       while(n >= 1){
        String s = '1' + reverse(invert(sb.toString()));
        sb.append(s);
        n--;
       }

       //System.out.println(sb);

       return sb.charAt(k-1);

    }

    public String invert(String s){
        StringBuilder sb  = new StringBuilder();

        for(char ch : s.toCharArray()){
            if(ch == '1'){
                sb.append('0');
            }
            else{
                sb.append('1');
            }
        }

        return sb.toString();
    }
    public String reverse(String s){
        return new StringBuilder(s).reverse().toString();
    }
}