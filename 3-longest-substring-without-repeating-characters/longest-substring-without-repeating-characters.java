class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if(n == 0) return 0;
        int ans = 1;

        int i = 0;
        int j = 0;
        HashSet<Character> set = new HashSet<>();
        while( j < n ){
            char ch  = s.charAt(j);
            if(set.contains(ch)){
                int len = j - i;
                 set.remove(s.charAt(i));
                i = i+1;
                ans = Math.max(ans , len);
               
            }
            else{
                set.add(ch);
                j++;
            }

        }

        ans = Math.max(ans ,  j -i);
        return ans;
    }
}