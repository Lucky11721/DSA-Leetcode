class Solution {
    public List<String> removeAnagrams(String[] arr) {
        int n = arr.length;
        int i = 0;
        int j = 1; 
        while(j < n){
            if(check_anagram(arr , i , j)){
                arr[j] = " ";
            }
            else{
                i = j;
            }
            j++;

        }
        System.out.println(Arrays.toString(arr));
        List<String> list = new ArrayList<>();

        for(int x = 0; x  < n ; x++){
            if (!arr[x].equals(" ")) {
                list.add(arr[x]);
            }
        }

        return list;

    }

    public boolean check_anagram(String[] arr , int i , int j ){
        int[] check = new int[26];
    if(arr[i].length() != arr[j].length()) return false;

    for(int x = 0 ; x < arr[i].length() ; x++){
          char ch = arr[i].charAt(x);
          check[ch - 'a'] += 1;
    }
     for(int x = 0 ; x < arr[j].length() ; x++){
          char ch = arr[j].charAt(x);
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