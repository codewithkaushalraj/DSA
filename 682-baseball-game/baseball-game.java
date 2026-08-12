class Solution {
    public int calPoints(String[] arr) {

        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            String Stchar = arr[i]; // means string character
            if (Stchar.equals("C"))
                s.pop();
            else if (Stchar.equals("D")) {
                int top = s.peek();
                top *= 2;
                s.push(top);
            } else if (Stchar.equals("+")) {
                int top = s.pop();
                int top2 = s.peek();
                int sum = top + top2;
                s.push(top);
                s.push(sum);
            } else {
                int num = Integer.parseInt(Stchar);
                s.push(num);
            }
        }
        int sum = 0;
        while (s.size() != 0) {
            sum += s.pop();
        }
        return sum;

    }
}