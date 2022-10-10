package linkedlist;

public class DeleteWithoutHead {

    Node head;

    class Node {
        int data;
        Node next;

        Node(int d) {
            this.data = d;
            this.next = null;
        }
    }

    public void push(int new_data) {

        Node new_Node = new Node(new_data);
        new_Node.next = head;
        head = new_Node;
    }

    public void printList() {

        Node tNode = head;
        while (tNode != null) {
            System.out.print(tNode.data + " ");
            tNode = tNode.next;
        }
    }

    public void deleteNode(Node node) {
        Node temp = node.next;
        node.data = temp.data;
        node.next = temp.next;
        temp = null;
    }

    // Time Complexity - O(n), Auxillary Space - O(1)
    public static void main(String[] args) {

        DeleteWithoutHead list = new DeleteWithoutHead();
        list.push(1);
        list.push(4);
        list.push(1);
        list.push(12);
        list.push(1);

        System.out.println("Before deleting");
        list.printList();

        list.deleteNode(list.head.next.next);

        System.out.println("\nAfter Deleting");
        list.printList();
    }
}
