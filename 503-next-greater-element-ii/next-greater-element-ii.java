class Solution {
    public int[] nextGreaterElements(int[] arr) {
        int n = arr.length;
        int[] nge = new int[n];
        Stack<Integer> s = new Stack<>();
        if(arr.length==1) {
            nge[0]=-1;
            return nge;
        }

        for (int i = 2 * (n - 1); i >= 0; i--) {
            int idx = i % n;
            int currElem = arr[idx];
            if (s.size() != 0 && currElem >= s.peek()) {
                while (s.size() != 0 && s.peek() <= currElem)
                    s.pop();
                if (s.size() == 0)
                    nge[idx] = -1;
                else
                    nge[idx] = s.peek();
            } else {
                if (s.size() != 0)
                    nge[idx] = s.peek();
            }
            s.push(currElem);
        }

        return nge;
    }
}