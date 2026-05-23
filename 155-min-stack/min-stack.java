class MinStack {
    Stack<Integer> s;
    Stack<Integer> min; // this will contain the minimum elemements of stack;

    public MinStack() {
        s = new Stack<>();
        min = new Stack<>();
    }

    public void push(int val) {
        s.push(val);
        if (min.isEmpty() || min.peek() >= val)
            min.push(val);
    }

    public void pop() {
        int ele = s.pop();
        if (!min.isEmpty() && ele == min.peek())
            min.pop();

    }

    public int top() {
        return s.peek();
    }

    public int getMin() {
        if(min.isEmpty()) return 0;
        return min.peek();
    }
}

// Solve by using of ArrayList
// class MinStack {
//     ArrayList<Integer> arr = new ArrayList<>();
//     int min = Integer.MAX_VALUE;

//     public MinStack() {
//         arr = new ArrayList<>();
//     }

//     public void push(int val) {
//         min = Math.min(min, val);
//         arr.add(val);
//     }

//     public void pop() {
//         arr.remove(arr.size() - 1);
//         min = Integer.MAX_VALUE;
//         for (int i = 0; i < arr.size(); i++)
//             min = Math.min(min, arr.get(i));
//     }

//     public int top() {
//         return arr.get(arr.size() - 1);

//     }

//     public int getMin() {
//         return min;

//     }
// }
