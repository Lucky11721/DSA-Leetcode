class Solution {
    public int intersectionSizeTwo(int[][] intervals) {

        // Sort by end asc, start desc
        Arrays.sort(intervals, (x, y) -> 
            x[1] == y[1] ? y[0] - x[0] : x[1] - y[1]
        );

        // Store only chosen elements (optional: can use two ints)
        List<Integer> chosen = new ArrayList<>();

        for (int[] arr : intervals) {
            int a = arr[0];
            int b = arr[1];

            int size = chosen.size();

            // Get last two chosen numbers
            int last1 = size > 0 ? chosen.get(size - 1) : -1;
            int last2 = size > 1 ? chosen.get(size - 2) : -1;

            // Count how many of last two are inside [a, b]
            int count = 0;
            if (last1 >= a && last1 <= b) count++;
            if (last2 >= a && last2 <= b) count++;

            // Case 1: already have 2 → do nothing
            if (count == 2) continue;

            // Case 2: have only 1 → add b
            if (count == 1) {
                chosen.add(b);
                continue;
            }

            // Case 3: have 0 → add b-1 and b
            chosen.add(b - 1);
            chosen.add(b);
        }

        return chosen.size();
    }
}
