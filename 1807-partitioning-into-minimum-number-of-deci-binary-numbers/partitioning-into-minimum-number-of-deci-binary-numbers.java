class Solution {

    public int minPartitions(String n) {
        
        int largest = -1;

        for(char x  : n.toCharArray()){
            largest = Math.max(largest , x - '0');
        }


        return largest;
    }
}