package queue;

public class StackQueueDequeue {

    static class Node {
        int value;
        Node next;
        Node prev;
    }

    static class deque {

        // Pointers to head and tail of deque
        private Node head;
        private Node tail;

        // Constructor
        public deque() {
            head = tail = null;
        }

        // If list is empty
        boolean isEmpty() {
            if (head == null)
                return true;

            return false;
        }

        // count the number of nodes in list
        int size() {

            // If list is not empty
            if (!isEmpty()) {
                Node temp = head;
                int len = 0;

                while (temp != null) {
                    len++;
                    temp = temp.next;
                }
                return len;
            }
            return 0;
        }

        // Insert at the first position
        void insertFirst(int element) {

            // Allocating node of Node type
            Node temp = new Node();
            temp.value = element;

            // If the element is first element
            if (head == null) {
                head = tail = temp;
                temp.next = temp.prev = null;
            } else {
                head.prev = temp;
                temp.next = head;
                temp.prev = null;
                head = temp;
            }
        }

        // Insert at last position of deque
        void insertLast(int element) {

            // Allocating node of Node type
            Node temp = new Node();
            temp.value = element;

            // If element is the first element
            if (head == null) {
                head = tail = temp;
                temp.next = temp.prev = null;
            } else {
                tail.next = temp;
                temp.next = null;
                temp.prev = tail;
                tail = temp;
            }
        }

        // Remove element at the first position
        void removeFirst() {

            // If list is not empty
            if (!isEmpty()) {
                head = head.next;
                head.prev = null;
                return;
            }
            System.out.print("List is Empty");
        }

        // Remove element at the last position
        void removeLast() {

            // If list is not empty
            if (!isEmpty()) {
                tail = tail.prev;
                if (tail != null) {
                    tail.next = null;
                }
                return;
            }
            System.out.print("List is Empty");
        }

        // Displays the elements in deque
        void display() {

            // If list is not empty
            if (!isEmpty()) {
                Node temp = head;

                while (temp != null) {
                    System.out.print(temp.value + " ");
                    temp = temp.next;
                }
                return;
            }
            System.out.print("List is Empty");
        }
    }

    // Class to implement stack using deque
    static class Stack {

        deque d = new deque();

        public void push(int element) {
            d.insertLast(element);
        }

        public int size() {
            return d.size();
        }

        public void pop() {
            d.removeLast();
        }

        public void display() {
            d.display();
        }
    }

    // Class to implement queue using deque
    static class Queue {

        deque d = new deque();

        public void enqueue(int element) {
            d.insertLast(element);
        }

        public void dequeue() {
            d.removeFirst();
        }

        public void display() {
            d.display();
        }

        public int size() {
            return d.size();
        }
    }

    // Time Complexity - O(N), Auxillary Space - O(N)
    public static void main(String[] args) {

    }
}
