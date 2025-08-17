class Solution {
    public int lastStoneWeight(int[] arr) {
        PriorityQueue<Integer> que = new PriorityQueue<>(Collections.reverseOrder());

        for(int i =0 ; i < arr.length ; i++){
            que.add(arr[i]);
        }
        System.out.println(que.peek());
        while(que.size() > 1){
            int a = que.poll();
            int b = que.poll();
             int c = a - b;
        if(c > 0){
            que.add(c);
        }
        }

        if(que.size() > 0){
            return que.peek();
        }
        else{
            return 0;
        }
    }
}