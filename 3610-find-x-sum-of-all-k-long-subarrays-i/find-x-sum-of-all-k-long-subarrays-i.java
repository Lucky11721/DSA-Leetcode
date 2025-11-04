import java.util.*;

class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] result = new int[n - k + 1];

        for (int i = 0; i <= n - k; i++) {
            // Step 1: Count frequency in current window
            Map<Integer, Integer> freq = new HashMap<>();
            for (int j = i; j < i + k; j++) {
                freq.put(nums[j], freq.getOrDefault(nums[j], 0) + 1);
            }

            // Step 2: Add entries into priority queue
            PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> {
                if (a.getValue().equals(b.getValue())) {
                    return Integer.compare(b.getKey(), a.getKey()); // larger number first if tie
                } else {
                    return Integer.compare(b.getValue(), a.getValue()); // higher freq first
                }
            });

            pq.addAll(freq.entrySet());

            // Step 3: Extract top x frequent elements
            Set<Integer> topX = new HashSet<>();
            int count = 0;
            while (!pq.isEmpty() && count < x) {
                topX.add(pq.poll().getKey());
                count++;
            }

            // Step 4: Calculate sum of all occurrences of top-x elements
            int sum = 0;
            for (int j = i; j < i + k; j++) {
                if (topX.contains(nums[j])) {
                    sum += nums[j];
                }
            }

            result[i] = sum;
        }

        return result;
    }
}
