class MinStack {
    Stack<Integer> st;
    Stack<Integer> minval;
    public MinStack() {
        st = new Stack<>();
        minval = new Stack<>();
    }
    
    public void push(int val) {
        st.push(val);
        if(minval.isEmpty() || minval.peek() >= st.peek()){
            minval.push(val);
        }
    }
    
    public void pop() {
        int popval = st.pop();
        if(popval == minval.peek()){
            minval.pop();
        }
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return minval.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */