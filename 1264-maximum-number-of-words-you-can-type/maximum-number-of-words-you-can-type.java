class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        
        HashSet<Character> set  = new HashSet<>();
        for(int  i = 0 ; i < brokenLetters.length() ; i++  ){
            set.add(brokenLetters.charAt(i));
        }
        int ans = 0;

        int  i = 0; 
        int j = 0;
        boolean flag = false;

        while(j < text.length()){
             flag = false;
            if(set.contains(text.charAt(j))){
                flag = true;
                while(j < text.length() && text.charAt(j) != ' '){
                    j++;
                }
            }
            if( j < text.length() &&  text.charAt(j) == ' ' && flag == false){
                ans++;
            }
            j++;
        }

        if(j == text.length() && flag == false){
            ans++;
        }

        return ans;
    }
}