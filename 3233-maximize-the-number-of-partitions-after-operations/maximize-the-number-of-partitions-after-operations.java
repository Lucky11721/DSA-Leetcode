import java.util.*;

class Solution {
    Map<String, Integer> memo = new HashMap<>();

    public int maxPartitionsAfterOperations(String s, int k) {
        char[] ch = s.toCharArray();
        return helper(ch, 0, 0, k, true) + 1; // +1 for last partition
    }

    private int helper(char[] ch, int index, int mask, int k, boolean canChange) {
        if (index >= ch.length) return 0;

        String key = index + "," + mask + "," + canChange;
        if (memo.containsKey(key)) return memo.get(key);

        int charIndex = ch[index] - 'a';
        int updateMask = mask | (1 << charIndex);
        int uniqueCount = Integer.bitCount(updateMask);

        int ans;
        if (uniqueCount > k) {
            ans = 1 + helper(ch, index + 1, 1 << charIndex, k, canChange);
        } else {
            ans = helper(ch, index + 1, updateMask, k, canChange);
        }

        if (canChange) {
            for (int newCharIndex = 0; newCharIndex < 26; newCharIndex++) {
                int newMask = mask | (1 << newCharIndex); // use mask, not updateMask
                int newCount = Integer.bitCount(newMask);

                if (newCount > k) {
                    ans = Math.max(ans, 1 + helper(ch, index + 1, 1 << newCharIndex, k, false));
                } else {
                    ans = Math.max(ans, helper(ch, index + 1, newMask, k, false));
                }
            }
        }

        memo.put(key, ans);
        return ans;
    }
}
