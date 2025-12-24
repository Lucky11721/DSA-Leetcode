class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int totalCap = 0;
        for(int pack : apple) totalCap += pack;

        Arrays.sort(capacity);
        int n = capacity.length;
        
        int count = 0;

        int currCapacity = 0;
        for(int i = n-1 ; i>= 0 ; i--){
            currCapacity += capacity[i];
            count++;
            if(currCapacity >= totalCap) break;
            
        }

        return count;
    }
}