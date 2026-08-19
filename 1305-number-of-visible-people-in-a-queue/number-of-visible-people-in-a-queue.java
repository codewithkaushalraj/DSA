class Solution {
    public int[] canSeePersonsCount(int[] arr) {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];
        st.push(arr[n - 1]);

        for (int i = n - 2; i >= 0; i--) {
            int count = 0;
            while (st.size() > 0 && st.peek() <= arr[i]) {
                count++;
                st.pop();
            }
            if (st.size() > 0)
                count++; // Important Point
            // this is because agar bo sabse bda element hua then on that case st ka size empty hoga
            ans[i] = count;
            st.push(arr[i]);
        }
        return ans;
    }
}