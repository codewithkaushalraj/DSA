class MinStack {
    ArrayList<Integer> arr = new ArrayList<>();
    int min = Integer.MAX_VALUE;

    public MinStack() {
        arr = new ArrayList<>();
    }

    public void push(int val) {
        min = Math.min(min, val);
        arr.add(val);
    }

    public void pop() {
        arr.remove(arr.size() - 1);
        min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.size(); i++)
            min = Math.min(min, arr.get(i));
    }

    public int top() {
        return arr.get(arr.size() - 1);

    }

    public int getMin() {
        return min;

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