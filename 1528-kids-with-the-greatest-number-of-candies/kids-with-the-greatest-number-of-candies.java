class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max_candies = 0;
        for(int ele : candies){
            max_candies = Math.max(max_candies ,ele);
        }
        int n = candies.length;
       List<Boolean> result = new ArrayList<>();
       System.out.println(result);

        for(int i = 0 ; i < n ; i++){
            int candy = candies[i] + extraCandies;
            if(candy >= max_candies){
              result.add(true);
            }
            else{
                result.add(false);
            }
        }
        return result;

    }
}