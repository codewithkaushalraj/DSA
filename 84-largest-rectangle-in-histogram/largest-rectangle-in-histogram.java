class Solution {
    public int largestRectangleArea(int[] arr) {
        int n = arr.length;
        int[] pse = new int[arr.length]; // pse -> preveiousSmallestElement
        int[] nse = new int[arr.length]; // nse -> nextSmallestElement
        Stack<Integer> s = new Stack<>();

        // first you need to calculate the previous smaller Element
        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i])
                s.pop();
            if (s.isEmpty())
                pse[i] = i + 1;
            else
                pse[i] = i - s.peek();
            s.push(i);
        }

        // Empty the stack
        while (!s.isEmpty())
            s.pop();

        // Recomputing the next smallest element;
        for (int i = n - 1; i >= 0; i--) {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i])
                s.pop();
            if (s.isEmpty())
                nse[i] = n - i;
            else
                nse[i] = s.peek() - i;
            s.push(i);
        }

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int width = pse[i] + nse[i] - 1;
            max = Math.max(max, (arr[i] * width));
        }
        return max;

    }
}