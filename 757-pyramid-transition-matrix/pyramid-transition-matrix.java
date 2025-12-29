class Solution {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        
        int n = bottom.length();

        HashMap<String,List<Character>> map = new HashMap<>();

        for(String s : allowed){
            
            String leftRight = s.substring(0 , 2);
            Character top  = s.charAt(2);

            map.putIfAbsent(leftRight , new ArrayList<>());

            map.get(leftRight).add(top);
        }

        return helper(bottom , 0 , map , new StringBuilder());

    }

    public boolean helper(String current , int index , 
                          HashMap<String,List<Character>> map , 
                          StringBuilder sb ){

                            if(current.length() == 1) return true;

                            if(index == current.length() -1 ){
                               return helper(sb.toString() , 0 , map , new StringBuilder());
                            }
                          
                           
                              String   pair = current.substring(index , index+2);
                            
                            

                            if(map.containsKey(pair) == false) return false;

                            for(Character top : map.get(pair)){
                                sb.append(top);
                                if(helper(current , index+1 , map , sb)) return true;
                                int size = sb.length();
                                sb.deleteCharAt(size-1);

                            }

                            return false;
    }
}