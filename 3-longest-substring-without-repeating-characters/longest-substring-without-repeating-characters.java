class Solution {
    public int lengthOfLongestSubstring(String s) {
        // using two pointer approach;  
         if(s.length()<=1) return s.length();
        HashMap<Character,Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        int maxlen = 0;
       
        while( j < s.length()){ 
            int len = j-i;
            maxlen = Math.max(len,maxlen);
            char ch = s.charAt(j);
            if(map.containsKey(ch) && map.get(ch)>=i){
              while(s.charAt(i)!=ch){
                i++;
              }
              i++;

            }
            else{map.put(ch,j);
            j++;
            }
        }
         int len = j-i;
            maxlen = Math.max(len,maxlen);
        return maxlen;
    }
}