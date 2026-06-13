class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        char[] alpha = new char[26];
        int x = 0;
        for(char ch = 'z' ; ch >= 'a' ; ch--){
            alpha[x] = ch;
            x++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < words.length ; i++){
            String s = words[i];
            int sum = 0;
            for(int j = 0 ; j < s.length() ; j++ ){
                int index = s.charAt(j) - 'a';
                sum =  (sum + weights[index]) % 26;
            }
            sb.append(alpha[sum]);
        }

       // System.out.println(Arrays.toString(alpha));


        return sb.toString();
    }
}