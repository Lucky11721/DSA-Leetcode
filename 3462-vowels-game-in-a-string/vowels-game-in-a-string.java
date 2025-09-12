class Solution {
    public boolean doesAliceWin(String s) {
        int n = s.length();
        HashSet<Character> set =  new HashSet<>();
        for(int i  = 0 ; i < n ; i++){
            set.add(s.charAt(i));
        }

        if(set.contains('a') || set.contains('e') || set.contains('i') || set.contains('o') || set.contains('u') ){
            return true;
        }

        return false;
    }
}