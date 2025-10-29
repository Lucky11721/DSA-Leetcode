class Solution {
    public int smallestNumber(int n) {

        while(isSet(n) == false){
           n++; 
        }

        return n;
    }

    public boolean isSet(int num){
        int check = num & (num+1);


        return check == 0;
    }
}