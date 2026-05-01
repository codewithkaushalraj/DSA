class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        int len = s.length();

        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (stk.isEmpty()) {
                stk.push(ch);
                continue;
            }
            if (stk.peek() == '}' || stk.peek() == ']' || stk.peek() == ')')
                return false;
            if (stk.peek() == '{' && ch == '}')
                stk.pop();
            else if (stk.peek() == '(' && ch == ')')
                stk.pop();
            else if (stk.peek() == '[' && ch == ']')
                stk.pop();
            else
                stk.push(ch);
        }
        if (stk.isEmpty())
            return true;
        else
            return false;

    }
}