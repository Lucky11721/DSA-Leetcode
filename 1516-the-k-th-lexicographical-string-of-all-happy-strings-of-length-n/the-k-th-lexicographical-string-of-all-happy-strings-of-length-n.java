class Solution {
    List<String> list;
    public String getHappyString(int n, int k) {
        list = new ArrayList<>();

        char[] arr = new char[3];
        int i= 0 ;
        for(char ch = 'a' ; ch <= 'c' ; ch++){
            arr[i++] = ch;   
        }
        solve(arr , new StringBuilder() , n , k);

        System.out.println(list);

        if(list.size() < k) return "";

        return list.get(k-1);
    }

    public void solve(char[] arr , StringBuilder s , int n , int k ){
        if(s.length() == n){
            list.add(s.toString());
            return;
        }


        for(int i = 0 ;i < 3 ; i++){
            if(s.length()  > 0 && s.charAt(s.length() -1) == arr[i]) continue;
            else{
                s.append(arr[i]);
                solve(arr , s, n , k );
                s.deleteCharAt(s.length() -1);
            }
        }
    }
}