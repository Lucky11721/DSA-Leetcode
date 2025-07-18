class Solution {
    public int addDigits(int n) {
       int sum = 0;

        // Repetitively calculate sum until
        // it becomes single digit
        while (n > 0 || sum > 9) {

            // If n becomes 0, reset it to sum 
            // and start a new iteration.
            if (n == 0) {
                n = sum;
                sum = 0;
            }

            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}