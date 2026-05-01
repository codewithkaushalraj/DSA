class Solution {
    public String removeDuplicates(String str) {

        char[] ch = str.toCharArray();
        Stack<Character> s = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (char ele : ch) {
            if (s.isEmpty()) {
                s.push(ele);
            } else if (s.peek() == ele)
                s.pop();
            else
                s.push(ele);
        }

        while (!s.isEmpty()) {
            sb.append(s.pop());
        }

        return sb.reverse().toString();

    }
}