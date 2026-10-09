class Solution {
    Set<String> set = new HashSet<>();
    int maxL = -1;
    public List<String> removeInvalidParentheses(String s) {

        set.clear();
        maxL = -1;

        remove(s,0, new StringBuilder());
        List<String> list= new ArrayList<>(set);


        return list;
    }

    public void remove(String s , int i , StringBuilder p){
        if(i == s.length()){
            if(valid(p.toString())){
                if(p.length() > maxL){
                    set.clear();
                    maxL = p.length();
                    set.add(p.toString());
                }
                else if(p.length() == maxL){
                    set.add(p.toString());
                }
            }
            return;
        }

        char ch = s.charAt(i);

        if(ch == '(' || ch == ')') {
            p.append(ch);
            remove(s,i+1 , p);
           p.deleteCharAt(p.length() -1);
            remove(s , i+1 , p);
        }
        else{
             p.append(ch);
            remove(s,i+1 , p);
            p.deleteCharAt(p.length() -1);
        }
    }


  public boolean valid(String str) {

    int count = 0;
    for (int i = 0; i < str.length(); i++) {


        if (str.charAt(i) == '(') {
            count++;
        } else if (str.charAt(i) == ')') {
            count--;
        }
        else{

        } 

        if (count < 0) {
            return false;
        }
    }
    return count == 0;
}
} 