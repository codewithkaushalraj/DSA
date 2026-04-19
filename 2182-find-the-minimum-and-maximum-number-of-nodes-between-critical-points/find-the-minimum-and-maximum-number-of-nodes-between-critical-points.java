/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {

        // // Base Cases;
        // int[] ans = new int[2];
        // ans[0] = -1;
        // ans[1] = -1;
        // List<Integer> temp = new ArrayList<>(); // It contins the all local minima
        // ListNode prev = head;
        // ListNode curr = head.next;
        // ListNode Next = head;
        // int idx = 1;
        // while (curr.next != null) {
        //     Next = curr.next;
        //     if (prev.val < curr.val && Next.val < curr.val)
        //         temp.add(idx);

        //     if (prev.val > curr.val && Next.val > curr.val)
        //         temp.add(idx);
        //     prev = curr;
        //     curr = Next;
        //     idx++;
        // }
        // if (temp.size() <= 1)
        //     return ans;
        // int len = temp.size();
        // // Now calculate the minimum distance
        // int min = Integer.MAX_VALUE;
        // for (int i = 0; i < len - 1; i++) {
        //     min = Math.min(min, Math.abs(temp.get(i) - temp.get(i + 1)));
        // }
        // ans[0] = min;
        // // Maximum distance is corect
        // ans[1] = temp.get(len - 1) - temp.get(0);
        // return ans;

        //------------------------------------Solved this problem with the help of constance extra space
        ListNode left = head;
        ListNode mid = head.next;
        ListNode right = head.next.next;
        int first = -1, last = -1;
        int[] ans = { -1, -1 };
        int idx = 1;
        int minDistance = Integer.MAX_VALUE;

        while (right != null) {
            if ((left.val < mid.val && right.val < mid.val) || (left.val > mid.val && right.val > mid.val)) {
                if (first == -1)
                    first = idx;
                if (last != -1)
                    minDistance = Math.min(minDistance, idx - last);
                last = idx;
            }
            idx++;
            left = left.next;
            mid = mid.next;
            right = right.next;
        }
        if (first == last)
            return ans;
        int maxDistance = last - first;

        ans[0] = minDistance;
        ans[1] = maxDistance;

        return ans;
    }
}