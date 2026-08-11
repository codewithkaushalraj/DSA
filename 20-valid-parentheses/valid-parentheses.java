class Solution {
    public boolean isValid(String s) {

        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(')
                st.push(')');
            else if (ch == '{')
                st.push('}');
            else if (ch == '[')
                st.push(']');
            else if (st.size() != 0 && st.peek() != ch)
                return false;
                else if( st.size()==0 && (ch==')'||ch=='}'|| ch==']'))
                return false;
            else
                st.pop();
        }
        if (st.size() != 0)
            return false;
        else
            return true;

    }
}