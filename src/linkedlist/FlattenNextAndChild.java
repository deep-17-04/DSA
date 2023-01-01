package linkedlist;

public class FlattenNextAndChild {

    class Node {
        int data;
        Node next;
        Node child;

        Node(int data) {
            this.data = data;
            this.next = this.child = null;
        }

        Node(int data, Node next, Node child) {
            this.data = data;
            this.next = next;
            this.child = child;
        }
    }

    void flattenList(Node node) {

        if (node == null) {
            return;
        }

        Node tmp = null;

        // Find tail node of first level linked list.
        Node tail = node;
        while (tail.next != null) {
            tail = tail.next;
        }

        Node cur = node;
        while (cur != tail) {

            if (cur.child != null) {

                // Then append the child at the end of current list.
                tail.next = cur.child;

                // Update the tail to new last node.
                tmp = cur.child;
                while (tmp.next != null) {
                    tmp = tmp.next;
                }
                tail = tmp;
            }
            cur = cur.next;
        }
    }

    // Time Complexity - O(N), Auxillary Space - O(1)
    public static void main(String[] args) {

    }
}
