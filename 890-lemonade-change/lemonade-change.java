class Solution {
    public boolean lemonadeChange(int[] bills) {
        int n = bills.length;
        int fiveDollar = 0;
        int tenDollar = 0;

        for(int i = 0 ; i < n ; i++){
            int currency  = bills[i];

            if(currency == 5){
                fiveDollar++;
            }
            else if(currency == 10){
                if(fiveDollar > 0 ){
                    fiveDollar--;
                    tenDollar++;
                }
                else{
                    return false;
                }
            }
            else if(currency == 20){
                if(fiveDollar > 0 && tenDollar > 0){
                    fiveDollar--;
                    tenDollar--;
                }
                else if(fiveDollar >2){
                    fiveDollar -= 3;
                }
                else return false;
            }
        }
        return true;
    }
}