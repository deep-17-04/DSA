package linkedlist;

public class DeleteGreater {

    class Node {

        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Create List
    public Node createList(int[] arr) {

        Node head = new Node(arr[0]);
        Node temp = head;

        Node newNode = null;
        for (int i = 1; i < arr.length; i++) {
            newNode = new Node(arr[i]);
            temp.next = newNode;
            temp = temp.next;
        }
        return head;
    }

    // Print List
    public void printList(Node head) {

        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static Node deleteNodesOnRightSide(Node head) {

        if (head == null || head.next == null)
            return head;

        Node nextNode = deleteNodesOnRightSide(head.next);
        if (nextNode.data > head.data)
            return nextNode;

        head.next = nextNode;
        return head;
    }

    // Time Complexity - O(n), Auxillary Space - O(1)
    public static void main(String[] args) {

        int[] arr = { 12, 15, 10, 11, 5, 6, 2, 3 };
        DeleteGreater list = new DeleteGreater();
        Node head = list.createList(arr);

        System.out.println("Given Linked List");
        list.printList(head);

        head = deleteNodesOnRightSide(head);

        System.out.println("Modified Linked List");
        list.printList(head);

    }
}
