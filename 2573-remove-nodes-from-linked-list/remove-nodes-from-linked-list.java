class Solution {

    //    For Method-1
    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode fwd = null;
        while (curr != null) {
            fwd = curr.next;
            curr.next = prev;
            prev = curr;
            curr = fwd;
        }
        return prev;
    }

    public ListNode removeNodes(ListNode head) {

        //------------------(Solved By LinkedList )----------------------
        if (head.next == null)
            return head;

        ListNode reverseHead = reverse(head);
        ListNode dummy = new ListNode(-1);
        ListNode newHead = dummy;
        int maxVal = Integer.MIN_VALUE;

        ListNode temp = reverseHead;

        while (temp != null) {
            if (temp.val >= maxVal) {
                dummy.next = temp;
                maxVal = temp.val;
                dummy = dummy.next;
            }
            temp = temp.next;
        }
        dummy.next = null;

        newHead = reverse(newHead.next);

        return newHead;



        //------------------(Solved By Stack )----------------
        // Stack<ListNode> st = new Stack<>();
        // ListNode temp = head;

        // while (temp != null) {
        //     if (st.size() != 0 && temp.val > st.peek().val) {
        //         while (st.size() != 0 && temp.val > st.peek().val)
        //             st.pop();
        //     }
        //     st.push(temp);
        //     temp = temp.next;
        // }

        // Stack<ListNode> temporary = new Stack<>();
        // while (st.size() != 0)
        //     temporary.push(st.pop());

        // ListNode dummy = new ListNode(-1);
        // ListNode newHead = dummy;
        // while (temporary.size() != 0) {
        //     dummy.next = temporary.pop();
        //     dummy = dummy.next;
        // }
        // return newHead.next;

    }
}