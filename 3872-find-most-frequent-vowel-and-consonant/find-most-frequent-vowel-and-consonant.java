class Solution {
    public int maxFreqSum(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();

        HashMap<Character , Integer> map = new HashMap<>();

        for(char ch : arr){
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
  if(map.containsKey(ch)){
                map.put(ch , map.get(ch) +1);
            }
            else{
                map.put(ch , 1);
            }
            }
        }
         for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }

        System.out.println("change from here");
        int maxVowel = 0;

        for(char ch : map.keySet()){
            maxVowel = Math.max(map.get(ch) , maxVowel);
        }
        map.clear();

        for(char ch : arr){
             if(ch != 'a' && ch != 'e' && ch != 'i' && ch != 'o' && ch != 'u'){
                 if(map.containsKey(ch)){
                map.put(ch , map.get(ch) +1);
            }
            else{
                map.put(ch , 1);
            }
             }
        }
         for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }

        int maxConst = 0;

       for(char ch : map.keySet()){
              maxConst = Math.max(maxConst ,map.get(ch) );
        }

        return maxConst  + maxVowel;

    }
}