/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node deepcopy(Node head) {
        Node temp = head;
        Node dummy = new Node(-1);
        Node new_head = dummy;
        while (temp != null) {
            Node n = new Node(temp.val);
            dummy.next = n;
            dummy = dummy.next;
            temp = temp.next;
        }
        return new_head.next;
    }

    public void connectAlternatively(Node head1, Node head2) {
        Node t1 = head1;
        Node t2 = head2;
        Node dummy = new Node(-1);
        Node temp = dummy;
        while (t1 != null && t2 != null) {
            temp.next = t1;
            t1 = t1.next;
            temp = temp.next;
            temp.next = t2;
            t2 = t2.next;
            temp = temp.next;
        }
    }

    public void assignRandomPointers(Node head, Node head2) {
        Node t1 = head;
        Node t2;
        while (t1 != null) {
            t2 = t1.next;
            if (t1.random != null)
                t2.random = t1.random.next;
            t1 = t1.next.next;
        }
    }

    public void splitLinkedList(Node head, Node head2) {
        Node t1 = head;
        Node t2 = head2;
        while (t1 != null) {
            t1.next = t2.next;
            t1 = t1.next;
            if (t1 == null)
                break;
            t2.next = t1.next;
            t2 = t2.next;
        }
    }

    public Node copyRandomList(Node head) {

        if (head == null)
            return head;

        //Step1: Create deep Copy without random connection
        Node head2 = deepcopy(head);

        // Step-2: Join head and head2 alternatively start from head;
        connectAlternatively(head, head2);

        // Step-3: Assign random pointers
        assignRandomPointers(head, head2);

        // Step-4: Split the linked list again
        splitLinkedList(head, head2);
        return head2;

    }
}