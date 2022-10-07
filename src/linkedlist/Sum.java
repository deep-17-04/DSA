package linkedlist;

import java.util.*;

public class Sum {

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node l1, l2, result;

    public static void push(int new_data, boolean list1) {

        Node new_node = new Node(new_data);

        if (list1) {
            new_node.next = l1;
            l1 = new_node;
        } else {
            new_node.next = l2;
            l2 = new_node;
        }
    }

    // To add two new numbers
    public static Node addTwoNumbers() {

        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        while (l1 != null) {
            stack1.add(l1.data);
            l1 = l1.next;
        }

        while (l2 != null) {
            stack2.add(l2.data);
            l2 = l2.next;
        }

        int carry = 0;
        Node result = null;

        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            int a = 0, b = 0;

            if (!stack1.isEmpty()) {
                a = stack1.pop();
            }

            if (!stack2.isEmpty()) {
                b = stack2.pop();
            }

            int total = a + b + carry;

            Node temp = new Node(total % 10);
            carry = total / 10;

            if (result == null) {
                result = temp;
            } else {
                temp.next = result;
                result = temp;
            }
        }

        // After While
        if (carry != 0) {
            Node temp = new Node(carry);
            temp.next = result;
            result = temp;
        }
        return result;
    }

    public static void printList() {

        while (result != null) {
            System.out.print(result.data + " ");
            result = result.next;
        }
        System.out.println();
    }

    // Time Complexity - O(n*logn), Auxillary Space - O(n)
    public static void main(String[] args) {

        int arr1[] = { 5, 6, 7 };
        int arr2[] = { 1, 8 };

        int size1 = 3;
        int size2 = 2;

        int i;
        for (i = size1 - 1; i >= 0; i--)
            push(arr1[i], true);

        for (i = size2 - 1; i >= 0; i--)
            push(arr2[i], false);

        result = addTwoNumbers();
        printList();
    }
}
