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
                if(st.size()>=2){
                  int ele1 = st.pop();
                  int ele2 = st.pop();
                  int sum = ele1 + ele2;
                   st.push(ele2);
                  st.push(ele1);
                  st.push(sum);
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