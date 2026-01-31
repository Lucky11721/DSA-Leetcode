class Solution {

    boolean isAnagram(int[] freqCount){
        for(int x : freqCount){
            if(x != 0 ) return false;
        }

        return true;
    }
    public List<Integer> findAnagrams(String s, String p) {

         int m = p.length();
         int n = s.length();

         int[] freqCount = new int[26];

         for(int i  =0 ;  i< m ; i++){
            freqCount[p.charAt(i) - 'a']++;
         }

         int i = 0;
         int j = 0;
         List<Integer> list = new ArrayList<>();

         while(j < n ){
             char ch = s.charAt(j);

             freqCount[ch -'a']--;

             if(j - i + 1 == m){
                if(isAnagram(freqCount)) list.add(i);
                freqCount[s.charAt(i) - 'a']++;
                i++;
             }

             j++;
         }

         return list;
    }
}