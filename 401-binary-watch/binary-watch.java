class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> list = new ArrayList<>();

        for(int h = 0 ; h <= 11 ; h++){
            int hourCount = countBit(h);

            for(int m = 0 ; m <= 59 ; m++ ){

                int minuteCount = countBit(m);
                int totalbitCount = hourCount + minuteCount;

                if(totalbitCount == turnedOn){
                 
                    String time = h + ":" + (m <= 9 ? "0" + m : m) ;
                    list.add(time);
                }

            }
        }

        return list;
    } 

    public int countBit(int n){
        int count = 0;
    while( n > 0){
        if((n & 1 ) ==  1){
            count++;
        }
        n = n >>1;
    }

    return count;
    }
}