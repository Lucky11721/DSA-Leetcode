class Solution {
    public List<String> removeAnagrams(String[] arr) {
        int n = arr.length;
       List<String> list = new ArrayList<>();
       list.add(arr[0]);
       for(int i = 1 ; i < n ; i++){
         if(check_anagram(arr[i] , list.get(list.size()-1)) == false){
            list.add(arr[i]);
         }
       }
        return list;

    }

    public boolean check_anagram(String a , String b ){
        int[] check = new int[26];
    if(a.length() != b.length()) return false;

    for(int x = 0 ; x < a.length() ; x++){
          char ch = a.charAt(x);
          check[ch - 'a'] += 1;
    }
     for(int x = 0 ; x < b.length() ; x++){
          char ch = b.charAt(x);
          check[ch - 'a'] -= 1;
    }

    for(int val : check){
        if(val > 0){
            return false;
        }
    }
    return true;

    }
}