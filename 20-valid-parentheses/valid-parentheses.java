class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        // int len = s.length();

        // for (int i = 0; i < len; i++) {
        //     char ch = s.charAt(i);
        //     if (stk.isEmpty()) {
        //         stk.push(ch);
        //         continue;
        //     }
        //     if (stk.peek() == '{' && ch == '}')
        //         stk.pop();
        //     else if (stk.peek() == '(' && ch == ')')
        //         stk.pop();
        //     else if (stk.peek() == '[' && ch == ']')
        //         stk.pop();
        //     else
        //         stk.push(ch);
        // }
        // if (stk.isEmpty())
        //     return true;
        // else
        //     return false;

        //-----------------Method 2nd--------------------

        for (char ch : s.toCharArray()) {
            if (ch == '(')
                stk.push(')');
            else if (ch == '{')
                stk.push('}');
            else if (ch == '[')
                stk.push(']');
            else {
                if (stk.isEmpty() || stk.pop() != ch)
                    return false;
            }
        }
        if (stk.isEmpty())
            return true;
        else
            return false;
    }
}