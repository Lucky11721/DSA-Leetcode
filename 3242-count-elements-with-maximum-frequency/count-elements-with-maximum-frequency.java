class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer , Integer> map = new HashMap<>();

        for(int ele : nums){
        if(map.containsKey(ele)){
            int freq = map.get(ele);
            map.put(ele , freq +1 );
        }
        else{
            map.put(ele , 1);
        }
        }

         for (HashMap.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println("key: " + entry.getKey() + ", value: " + entry.getValue());
        }
        int maxFreq = 0;

        for(int ele : map.keySet()){
            int count = map.get(ele);

            maxFreq  = Math.max(maxFreq , count);
        }

        int ans = 0;
        for(int ele : map.keySet()){
            int count = map.get(ele);

            if(count == maxFreq) ans += count;
        }

        
        System.out.println(maxFreq);
        return ans;
    }
}