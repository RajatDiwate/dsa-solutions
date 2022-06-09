package com.practice.linkedList;

public class ReverseInGroups {
    public static Node head;

    public static class Node {
        int data;
        Node nextNode;
    }

    public static void main(String... args) {
        addElementBefore(3);
        addElementBefore(4);
        addElementBefore(5);
        addElementBefore(8);
        addElementBefore(33);
        addElementBefore(22);
        addElementBefore(566);
        addElementBefore(544);
        printAllEle();
        head= reverseLLInGroups(head, 3);
        printAllEle();
    }

    private static Node reverseLLInGroups(Node head, int i) {
        int length = 1;
        Node curr=head;
        Node prev = null;
        Node nextOfCurr = null;
        while (curr != null && length <= i) {
            nextOfCurr = curr.nextNode;
            curr.nextNode = prev;
            prev = curr;
            curr = nextOfCurr;
            length++;
        }

        if (nextOfCurr != null)
           head.nextNode= reverseLLInGroups(curr, i);

        return prev;

    }

    private static void printAllEle() {
        if (head == null) {
            System.out.println("LL is empty");
        }
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.nextNode;
        }
        System.out.println();

    }

    private static void addElementBefore(int inputData) {
        Node newNode = new Node();
        newNode.data = inputData;
        newNode.nextNode = head;
        head = newNode;
    }


}
