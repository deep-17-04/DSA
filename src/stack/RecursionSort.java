package stack;

import java.util.ListIterator;
import java.util.Stack;

public class RecursionSort {

    // Recursive Method to insert an item x in sorted way
    static void sortedInsert(Stack<Integer> s, int x) {

        if (s.isEmpty() || x > s.peek()) {
            s.push(x);
            return;
        }

        // If top is greater, remove the top item and Recur.
        int temp = s.pop();
        sortedInsert(s, x);
        s.push(temp);
    }

    // Method to sort stack
    static void sortStack(Stack<Integer> s) {

        if (!s.isEmpty()) {

            int x = s.pop();
            sortStack(s);
            sortedInsert(s, x);
        }
    }

    // Utility Method to print contents of stack
    static void printStack(Stack<Integer> s) {

        ListIterator<Integer> lt = s.listIterator();
        while (lt.hasNext())
            lt.next();
        while (lt.hasPrevious())
            System.out.print(lt.previous() + " ");
    }

    // Time Complexity - O(n^2), Auxillary Space - O(n)
    public static void main(String[] args) {

        Stack<Integer> s = new Stack<>();
        s.push(30);
        s.push(-5);
        s.push(18);
        s.push(14);
        s.push(-3);

        System.out.println("Stack elements before sorting: ");
        printStack(s);
        sortStack(s);
        System.out.println("Stack elements after sorting:");
        printStack(s);
    }
}
