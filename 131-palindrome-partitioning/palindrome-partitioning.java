class Solution {
    List<List<String>> ans;

    public List<List<String>> partition(String s) {
        ans = new ArrayList<>();
        helper(s.toCharArray(), 0, new ArrayList<>(), "");
        return ans;
    }

    public void helper(char[] arr, int index, List<String> list, String str) {
        if (index == arr.length) {
            if (str.length() == 0) { // only valid if we closed all pieces
                ans.add(new ArrayList<>(list));
            }
            return;
        }

        // pick current character into ongoing string
        str += arr[index];

        // case 1: if str is palindrome → cut here
        if (isPal(str)) {
            list.add(str);                        // pick str
            helper(arr, index + 1, list, "");     // reset str for next partition
            list.remove(list.size() - 1);         // backtrack
        }

        // case 2: skip cutting → extend str
        helper(arr, index + 1, list, str);
    }

    public boolean isPal(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
