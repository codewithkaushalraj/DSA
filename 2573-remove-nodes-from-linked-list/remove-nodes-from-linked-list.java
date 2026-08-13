class Solution {

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

        if (head.next == null)
            return head;

        // This Logic is correct but there has a time limit exceeded error 
        // for big test cases 

        // ListNode dummy = new ListNode(-1);
        // ListNode NewHead = dummy;
        // ListNode temp1 = head;
        // ListNode temp2 = head.next;

        // while (temp1 != null) {
        //     boolean isLesser = false;
        //     while (temp2 != null) {
        //         if (temp1.val < temp2.val) {
        //             isLesser = true;
        //             break;
        //         }
        //         temp2 = temp2.next;
        //     }
        //     if (!isLesser) {
        //         dummy.next = temp1;
        //         dummy = dummy.next;
        //     }
        //     temp1 = temp1.next;
        //     if (temp1 != null)
        //         temp2 = temp1.next;
        // }
        // return NewHead.next;

        //----------------------------------------------

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

    }
}