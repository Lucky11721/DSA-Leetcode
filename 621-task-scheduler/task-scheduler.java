import java.util.*;

public class Solution {
    class Pair {
        int count;
        int time;
        Pair(int count, int time) {
            this.count = count;
            this.time = time;
        }
    }

    public int leastInterval(char[] tasks, int k) {
       int n = tasks.length;
         HashMap<Character, Integer> map = new HashMap<>();
        for (char ele : tasks) {
             if(map.containsKey(ele)){
                map.put(ele , map.get(ele) +1);
             }
             else{
                map.put(ele,1);
             }
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int freq : map.values()) {
            maxHeap.add(freq);
        }

        int time = 0;
        Queue<Pair> que = new LinkedList<>();

        while(maxHeap.isEmpty() == false || que.isEmpty() == false){
            time++;

            if(maxHeap.isEmpty()){
                time = que.peek().time;
            }
            else{
                int value = maxHeap.poll() -1;
                if(value > 0){
                    que.add(new Pair(value , time + k));
                }
            }

            if(que.isEmpty() == false && que.peek().time== time){
                maxHeap.add(que.poll().count);
            }
        }
        return time;
    }
}
