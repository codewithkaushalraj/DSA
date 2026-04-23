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
            if (temp.child != null) {
                Node nextNode = temp.next;
                Node child = temp.child;
                temp.child = null;

                Node newHead = flatten(child);
                temp.next = newHead;
                newHead.prev = temp;

                Node tail = newHead;
                while (tail.next != null)
                    tail = tail.next;
                tail.next = nextNode;
                if (nextNode != null)
                    nextNode.prev = tail;
                temp = nextNode;
            }
            if (temp != null)
                temp = temp.next;
        }
        return head;

    }
}