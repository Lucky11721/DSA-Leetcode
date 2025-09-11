class Solution {
    public String sortVowels(String s) {
        int n = s.length();
        int count = 0 ;
        for(int  i  = 0 ; i <  n ; i++){
            if(isVowel(s.charAt(i))){
                count++;
            }
        }
        char[] ch = new char[count];
        int index = 0;
        for(int i = 0 ; i < n ; i++){
             if(isVowel(s.charAt(i))){
                ch[index] = s.charAt(i);
                index++;
            }
        }
        Arrays.sort(ch);
        StringBuilder sb = new StringBuilder();
        index = 0;
        for(int i = 0 ; i < n ; i++){
             if(isVowel(s.charAt(i))){
               sb.append(ch[index]);
                index++;
            }
            else{
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
    public boolean isVowel(char c){
        String str = "AaEeIiOoUu";
        int index = str.indexOf(c);

        if(index != -1) return true;
        else return false;
    }
}
