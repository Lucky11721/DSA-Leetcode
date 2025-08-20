class Solution {
    class Pair {
        char ch;
        int count;
        Pair(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }

    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Pair> maxheap = new PriorityQueue<>((x, y) -> y.count - x.count);

        if (a > 0) maxheap.add(new Pair('a', a));
        if (b > 0) maxheap.add(new Pair('b', b));
        if (c > 0) maxheap.add(new Pair('c', c));

        StringBuilder sb = new StringBuilder();

        while (!maxheap.isEmpty()) {
            Pair first = maxheap.poll();

            int len = sb.length();
            if (len >= 2 && sb.charAt(len - 1) == first.ch && sb.charAt(len - 2) == first.ch) {
                // Can't use first now, try second
                if (maxheap.isEmpty()) break;
                Pair second = maxheap.poll();
                sb.append(second.ch);
                second.count--;
                if (second.count > 0) maxheap.add(second);
                maxheap.add(first); // put first back
            } else {
                sb.append(first.ch);
                first.count--;
                if (first.count > 0) maxheap.add(first);
            }
        }

        return sb.toString();
    }
}
