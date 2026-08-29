class MyStack {
    Queue<Integer> q;

    public MyStack() {
        q = new LinkedList<>();
    }

    public void push(int x) {
        q.add(x);
    }

    public int pop() {
        int n = q.size();
        for (int i = 1; i < n; i++)
            q.add(q.remove());
        int elem = q.remove();
        return elem;
    }

    public int top() {
        int n = q.size();
        for (int i = 1; i < n; i++)
            q.add(q.remove());
        int top = q.remove();
        q.add(top);
        return top;
    }

    public boolean empty() {
        if (q.size() == 0)
            return true;
        else
            return false;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */