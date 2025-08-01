class Solution {
    public int calPoints(String[] arr) {
        int n = arr.length;
        
        Stack<Integer> st = new Stack<>();

        for(int i = 0 ;i <  n ;i++){

            if(arr[i].equals("C")){
                if(st.isEmpty() == false){
                    st.pop();
                }
            }
            else if(arr[i].equals("D")){
                 if(st.isEmpty() == false){
                    st.push(st.peek() * 2);
                } 
            }
            else if(arr[i].equals("+")){
                if (st.size() >= 2) {
                    int last = st.peek();
                    int secondLast = st.get(st.size() - 2);
                    st.push(last + secondLast);
                }
            }
            else{
                int value = Integer.valueOf(arr[i]);
                st.push(value);
            }
        }
        int ans = 0;
        for(int ele : st){
            System.out.print(ele + " ");
        }

        while(!st.isEmpty()){
            ans += st.pop();
        }
        return ans;
    }
}