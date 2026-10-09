class Solution {

    public String removeOuterParentheses(String s) {

        Stack<Integer> st = new Stack<>();
        Set<Integer> set = new TreeSet<>();

        int n = s.length();

        for (int i = 0; i < n; i++) {

            char ch = s.charAt(i);

            if (ch == '(') {

                if (st.isEmpty()) {
                    set.add(i);
                }

                st.push(i);

            }

            else {

                int index = st.pop();

                if (st.isEmpty()) {
                    set.add(i);
                }
            }
        }

       
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < n; i++) {

            if (!set.contains(i)) {
                ans.append(s.charAt(i));
            }
        }

        return ans.toString();
    }
}