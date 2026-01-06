class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int maxCookies = 0;
        int m = g.length;
        int n = s.length;
       Arrays.sort(g);
      Arrays.sort(s);

        int l = 0;
        int r = 0;

        while(l < m && r <n){
            if(s[r] >= g[l]){
                l = l+1;
            }
           r = r+1;
           
        }

        return l;
    }
}