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
        if (head == null) {
            return head;
        }

        Node curr = head;
        while (curr != null) {
            if (curr.child != null) {

                Node next = curr.next;
                Node childHead = curr.child;

                curr.next = childHead;
                childHead.prev = curr;

                Node tail = childHead;
                while (tail.next != null) {
                    tail = tail.next;
                }

                tail.next = next;

                if (next != null) {
                    next.prev = tail;
                }

                curr.child = null;
            }
            curr = curr.next;
        }
        return head;
    }
}
