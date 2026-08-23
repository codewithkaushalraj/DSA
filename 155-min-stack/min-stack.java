class MinStack {
    Stack<Integer> st;
    Stack<Integer> minSt;

    public MinStack() {
        st = new Stack<>();
        minSt = new Stack<>();

    }

    public void push(int value) {
        if (st.size() == 0) {
            st.push(value);
            minSt.push(value);
        } else {
            if (value > minSt.peek())
                minSt.push(minSt.peek());
            else
                minSt.push(value);
            st.push(value);
        }

    }

    public void pop() {
        st.pop();
        minSt.pop();

    }

    public int top() {
        return st.peek();

    }

    public int getMin() {
        return minSt.peek();

    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */