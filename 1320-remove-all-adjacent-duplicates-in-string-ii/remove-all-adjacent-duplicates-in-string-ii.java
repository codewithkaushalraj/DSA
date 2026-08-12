class Solution {
    public String removeDuplicates(String s, int k) {

        Stack<Character> st = new Stack<>();
        Stack<Integer> count = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (st.size() == 0) {
                st.push(ch);
                count.push(1);
            } else {
                char topElem = st.peek();
                if (topElem == ch) {
                    int countTop = count.pop();
                    count.push(++countTop);
                    st.push(ch);

                    if (count.peek() == k) {
                        while (st.size() != 0 && st.peek() == ch)
                            st.pop();
                        count.pop();
                    }
                } else {
                    st.push(ch);
                    count.push(1);
                }
            }
        }
        Stack<Character> temp = new Stack<>();

        while (st.size() != 0)
            temp.push(st.pop());
        String ans = "";
        while (temp.size() != 0)
            ans += temp.pop();

        return ans;

    }
}