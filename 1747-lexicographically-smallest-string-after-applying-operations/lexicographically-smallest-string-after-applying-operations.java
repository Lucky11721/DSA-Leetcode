import java.util.*;

class Solution {
    public String findLexSmallestString(String s, int a, int b) {
        Set<String> visited = new HashSet<>();
        String smallest = s;
        
        Queue<String> q = new LinkedList<>();
        q.add(s);
        visited.add(s);
        
        while (!q.isEmpty()) {
            String cur = q.poll();
            
            // update smallest
            if (cur.compareTo(smallest) < 0) {
                smallest = cur;
            }
            
            // operation 1: add a to odd indices
            char[] arr = cur.toCharArray();
            for (int i = 1; i < arr.length; i += 2) {
                arr[i] = (char)(((arr[i] - '0' + a) % 10) + '0');
            }
            String addOp = new String(arr);
            if (visited.add(addOp)) {
                q.add(addOp);
            }
            
            // operation 2: rotate by b
            String rotateOp = cur.substring(cur.length() - b) + cur.substring(0, cur.length() - b);
            if (visited.add(rotateOp)) {
                q.add(rotateOp);
            }
        }
        
        return smallest;
    }
}
