package linkedlist;

import java.util.HashMap;

public class ListCycle {

    Node head;

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public boolean hasCycle(Node head) {

        if (head == null) {
            return false;
        }

        HashMap<Node, Integer> map = new HashMap<>();

        while (head.next != null) {
            if (!map.containsKey(head)) {
                map.put(head, head.data);
            } else {
                return true;
            }
            head = head.next;
        }
        return false;
    }
}
