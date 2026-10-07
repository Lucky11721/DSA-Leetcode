class Solution {
    public int scoreOfParentheses(String s) {

        List<Integer> list = new ArrayList<>();

        int sc = 0;


        for(int i = 0 ; i < s.length() ;  i++){
            char ch = s.charAt(i);

            if(ch == '('){
                list.add(sc);
                sc = 0;
            }
            else{
                if(s.charAt(i-1) == '('){
                    sc = list.get(list.size() -1) +1;
                }
                else{
                    sc = list.get(list.size()-1) + (2*sc);
                }
        list.remove(list.size()-1);
            }
        }

        System.out.println(list);
        return sc;
        
    }
}