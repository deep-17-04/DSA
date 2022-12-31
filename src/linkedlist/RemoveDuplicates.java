package linkedlist;

import java.util.HashSet;

public class RemoveDuplicates {

    Node head;

    class Node {

        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void push(int data) {

        Node new_node = new Node(data);
        new_node.next = head;
        head = new_node;
    }

    public void removeDuplicates() {

        HashSet<Integer> hs = new HashSet<>();

        Node current = head;
        Node prev = null;

        while (current != null) {
            int value = current.data;

            if (hs.contains(value)) {
                prev.next = current.next;
            } else {
                hs.add(value);
                prev = current;
            }
            current = current.next;
        }
    }

    void printList() {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    // Time Complexity - O(N), Auxillary Space - O(N)
    public static void main(String[] args) {

        RemoveDuplicates list = new RemoveDuplicates();
        list.push(12);
        list.push(14);
        list.push(23);
        list.push(25);
        list.push(14);
        list.push(5);
    }
}
