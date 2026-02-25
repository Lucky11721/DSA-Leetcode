class Solution {
    class Pair{
        int num;
        int setBitCount;

        Pair(int num , int setBitCount){
            this.num = num;
            this.setBitCount = setBitCount;
        }
    }
    public int[] sortByBits(int[] arr) {

        PriorityQueue<Pair> list = new PriorityQueue<>((a,b) -> {
            if(a.setBitCount == b.setBitCount){
                return Integer.compare(a.num , b.num);
            }
            else{
                return Integer.compare(a.setBitCount , b.setBitCount);
            }
        });

        for(int i =  0 ; i < arr.length ; i++){
            int num = arr[i];
            int bitCount = countBit(arr[i]);

            list.add(new Pair(num , bitCount));
        }

        int[] ans = new int[arr.length];

        int x= 0;
      while(list.isEmpty() == false){
        Pair p = list.remove();
        ans[x] = p.num;
        x++;
      }
        return ans;


    }

    public int countBit(int num){
        int count = 0;
        while(num > 0){
            if((num & 1) == 1) count++;
            num = num >>1;
        }
        return count;
    }
}