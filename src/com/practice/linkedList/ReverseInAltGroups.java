package com.practice.linkedList;

public class ReverseInAltGroups {
    public static class Node {
        int data;
        Node nextNode;
    }

    public static Node head;

    public static void main(String[] args) {
        addNode(3);
        addNode(4);
        addNode(5);
        addNode(6);
        addNode(7);
        addNode(33);
        addNode(22);
        printLL();
        head = reverseAltNodes(head, 2);
        printLL();
    }

    private static Node reverseAltNodes(Node node, int i) {
        int len = 1;
        Node curr = node;
        Node prev = null;
        Node nextNode = null;
        while (curr != null && len <= i) {
            nextNode = curr.nextNode;
            curr.nextNode = prev;
            prev = curr;
            curr = nextNode;
            len++;
        }
        if (node != null) {
            node.nextNode = curr;
        }
        int count = 0;
        while (curr != null && count <i-1) {
            curr = curr.nextNode;
            count++;
        }
        if (curr != null)
            curr.nextNode = reverseAltNodes(curr.nextNode, i);
        return prev;
    }

    private static void printLL() {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.nextNode;
        }
        System.out.println();
    }

    private static void addNode(int inputData) {
        Node newNode = new Node();
        newNode.data = inputData;
        newNode.nextNode = null;
        if (head == null) {
            head = newNode;
            return;
        }
        Node curr = head;
        while (curr.nextNode != null) {
            curr = curr.nextNode;
        }
        curr.nextNode = newNode;
    }
}
