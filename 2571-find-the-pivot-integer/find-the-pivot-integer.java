class Solution {
    public int pivotInteger(int n) {

      int i = 1;
      int j = n;

      int leftsum = i;
      int rightsum = n;

      while(i < j){
        if(leftsum < rightsum){
            i++;
            leftsum += i;
        }
        else{
            j--;
            rightsum += j; 
        }
      }   

      if(leftsum == rightsum && i==j){
        return i;
      }

      return -1;
    }
}