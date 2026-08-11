class Solution {
    public String removeDuplicates(String s) {

        Stack<Character> st = new Stack<>();
        String ans = "";

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (st.size() == 0)
                st.push(ch);
            else {
                char topElem = st.peek();
                if (topElem == ch)
                    st.pop();
                else
                    st.push(ch);
            }
        }
        Stack<Character> temp = new Stack<>();

        while (st.size() != 0)
            temp.push(st.pop());

        while (temp.size() != 0)
            ans += temp.pop();

        return ans;
    }
}