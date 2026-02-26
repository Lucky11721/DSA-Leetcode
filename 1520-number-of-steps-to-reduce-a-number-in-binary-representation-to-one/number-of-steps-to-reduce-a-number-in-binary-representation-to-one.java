import java.math.BigInteger;

class Solution {
    public int numSteps(String s) {

        BigInteger num = new BigInteger(s, 2);

        BigInteger one = BigInteger.ONE;
        BigInteger two = new BigInteger("2");

        int step = 0;

        while (num.compareTo(one) > 0) {

            // check odd or even
            if (num.mod(two).equals(BigInteger.ONE)) {
                num = num.add(one);
            } else {
                num = num.divide(two);
            }

            step++;
        }

        return step;
    }
}