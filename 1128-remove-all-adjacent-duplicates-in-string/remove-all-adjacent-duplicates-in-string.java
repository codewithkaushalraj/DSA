class Solution {
    public String reverse(String s) {
        char[] ch = s.toCharArray();
        int i = 0, j = ch.length - 1;
        while (i < j) {
            char c = ch[i];
            ch[i] = ch[j];
            ch[j] = c;
            i++;
            j--;
        }
        return new String(ch);
    }

    public String removeDuplicates(String str) {

        char[] ch = str.toCharArray();
        Stack<Character> s = new Stack<>();
        String ans = "";

        for (char ele : ch) {
            if (s.isEmpty()) {
                s.push(ele);
            } else if (s.peek() == ele)
                s.pop();
            else
                s.push(ele);
        }

        while (!s.isEmpty()) {
            ans += s.pop();
        }

        return reverse(ans);

    }
}