class Solution {
    public int countPalindromicSubsequence(String s) {
        char[] arr = s.toCharArray();
           int n = arr.length;
        int ans = 0;
        Set<Character> set = new HashSet<>();
        for(char ch : arr){
            set.add(ch);
        }

        for(char letter : set){
            int left_index = -1;
            int right_index = -1;
            for(int i = 0 ; i < n ; i++){
                
            if(arr[i] == letter){
                if(left_index == -1){
                    left_index = i;
                }
                
                right_index = i;
            }
            }
            Set<Character> curr = new HashSet<>();

            for(int middle = left_index +1 ; middle < right_index ; middle++){
                curr.add(arr[middle]);
            }

            ans += curr.size();
        }

return ans;

    }
}