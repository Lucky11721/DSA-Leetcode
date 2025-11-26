class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        char[] ch = s1.toCharArray();
        Arrays.sort(ch);
        String s = new String(ch);
        int i = 0 ;
        int j = m;

        while(j <= n){
            char[] arr = s2.substring(i , j).toCharArray();
            Arrays.sort(arr);
           
            String str = new String(arr);
            if(s.equals(str)) return true;
            i++;
            j++;
        }

        return false;
    }
}