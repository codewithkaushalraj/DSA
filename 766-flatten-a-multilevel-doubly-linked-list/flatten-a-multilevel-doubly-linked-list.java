/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        Node temp = head;
        while (temp != null) {
            Node Next = temp.next;

            if (temp.child != null) {
                Node child = temp.child;
                temp.child = null;

                Node newchild = flatten(child);
                temp.next = newchild;
                newchild.prev = temp;

                Node tail = newchild;
                while (tail.next != null)
                    tail = tail.next;
                tail.next = Next;
                if (Next != null)
                    Next.prev = tail;
            }
            temp = Next;
        }
        return head;

    }
}