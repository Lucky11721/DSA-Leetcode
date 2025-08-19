

class Solution {
    class Pair{
        char ch;
        int count;
        Pair(char ch , int count){
            this.ch = ch;
            this.count = count;
        }
    }
    public String reorganizeString(String s) {
        
        char[] arr = s.toCharArray();
        HashMap<Character , Integer> map = new HashMap<>();
        for(char ele : arr){
            if(map.containsKey(ele)){
                map.put(ele , map.get(ele)+1);
            }
            else{
                map.put(ele,1);
            }
        }
        PriorityQueue<Pair> maxheap = new PriorityQueue<>((a,b) -> Integer.compare(b.count , a.count));
        
        for(char key : map.keySet()){
            int freq = map.get(key);

            maxheap.add(new Pair(key , freq));
        }
        System.out.println(maxheap.peek().ch);
        Queue<Pair> que = new LinkedList<>();

        StringBuilder sb = new StringBuilder();

        while(maxheap.isEmpty() == false){
            Pair p = maxheap.poll();
            sb.append(p.ch);
            p.count--;
            que.add(p);

            if(que.size() >= 2){
              Pair front = que.poll();
              if(front.count > 0){
                maxheap.add(front);
              }
            }


        }
        
        if(sb.length() == s.length()){
            return sb.toString();
        }

        return "";
    }
}