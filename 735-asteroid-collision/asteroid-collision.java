class Solution {
    public int[] asteroidCollision(int[] arr) {
        int n = arr.length;

        Stack<Integer> st = new Stack<>();

        for(int ele : arr){

            int curr = ele;

            while(!st.isEmpty() && curr < 0 && st.peek() > 0){
                int diff = curr + st.peek();

                if(diff > 0){
                    curr = 0;
                }
                else if(diff < 0){
                    st.pop();
                }
                else{
                    curr = 0;
                    st.pop();
                }    
            }

            if(curr != 0 )st.push(curr);
        }
        System.out.println(st);

        int ans[] = new int[st.size()];
        int x = ans.length-1 ; 
        while(!st.isEmpty()){
            ans[x--] = st.pop(); 
        }
        return ans;
    }
}