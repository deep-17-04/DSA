package linkedlist;

import java.util.*;

public class RemoveLoop {

    class Node {
        int data;
        Node next;

        Node(int d) {
            this.data = d;
            this.next = null;
        }
    }

    Node head;

    public void push(int new_data) {

        Node new_node = new Node(new_data);
        new_node.next = head;
        head = new_node;
    }

    void printList() {

        Node node = head;
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    public boolean removeLoop() {

        HashSet<Node> s = new HashSet<Node>();
        Node prev = null;
        Node node = head;

        while (node != null) {

            if (s.contains(node)) {
                prev.next = null;
                return true;
            } else {
                s.add(node);
                prev = node;
                node = node.next;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        RemoveLoop list = new RemoveLoop();
        list.push(20);
        list.push(4);
        list.push(15);
        list.push(10);
        list.head.next.next.next.next = list.head;

        if (list.removeLoop()) {
            System.out.println("Linked List after removing loop");
            list.printList();
        } else
            System.out.println("No Loop found");
    }
}
