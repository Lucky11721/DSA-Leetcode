class Solution {
    public int totalMoney(int n) {
      
        int completeweeks = n/7;
        System.out.println(completeweeks);
        // apply AP;
        int first_term = 28; // sum of money of first week;
        // calculate last term
        int last_term = first_term +(completeweeks - 1)* 7;
        // sum of money for all complete weeks

        double result = (completeweeks*(first_term+last_term))/2;
        System.out.println(result);
        // remaining days
        int remaining_days = n%7;

        int start_money = completeweeks+1;

        for(int i = 1; i <=remaining_days ; i++){
            result += start_money;
            start_money++;
        }

return (int)result;
        
    }
}