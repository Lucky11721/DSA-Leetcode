class Solution {
    public String sortVowels(String s) {
        int n = s.length();
        int count = 0 ;
        for(int  i  = 0 ; i <  n ; i++){
            if(s.charAt(i) == 'A' || s.charAt(i) == 'a'  || s.charAt(i) == 'E' || s.charAt(i) == 'e' || 
            s.charAt(i) == 'I' || s.charAt(i) == 'i' || s.charAt(i) == 'O' 
            || s.charAt(i) == 'o' || s.charAt(i) == 'U' || s.charAt(i) == 'u'){
           count++;
            }
        }
        char[] ch = new char[count];
        int index = 0;
        for(int i = 0 ; i < n ; i++){
             if(s.charAt(i) == 'A' || s.charAt(i) == 'a'  || s.charAt(i) == 'E' || s.charAt(i) == 'e' || 
            s.charAt(i) == 'I' || s.charAt(i) == 'i' || s.charAt(i) == 'O' 
            || s.charAt(i) == 'o' || s.charAt(i) == 'U' || s.charAt(i) == 'u'){
                  ch[index] = s.charAt(i);
                  index++;
            }
        }
        Arrays.sort(ch);
        StringBuilder sb = new StringBuilder();
        index = 0;
        for(int i = 0 ; i < n ; i++){
             if(s.charAt(i) == 'A' || s.charAt(i) == 'a'  || s.charAt(i) == 'E' || s.charAt(i) == 'e' || 
            s.charAt(i) == 'I' || s.charAt(i) == 'i' || s.charAt(i) == 'O' 
            || s.charAt(i) == 'o' || s.charAt(i) == 'U' || s.charAt(i) == 'u'){
                  sb.append(ch[index]);
                  index++;
            }
            else{
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}