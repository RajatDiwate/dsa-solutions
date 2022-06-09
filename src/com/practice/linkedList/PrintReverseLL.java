package com.practice.linkedList;


public class PrintReverseLL {
    public static Node head;

    public static class Node {
        int data;
        Node nextNode;
    }

    public static void main(String[] args) {
        addNode(3);
        addNode(5);
        addNode(6);
        addNode(7);
        addNode(33);
        addNode(22);
        printAll();
        dummyReverse(head);
    }

    private static void dummyReverse(Node head) {
        if(head==null){
            return;
        }
        dummyReverse(head.nextNode);
        System.out.print(head.data+ " ");
    }

    private static void printAll() {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.nextNode;
        }
        System.out.println();
    }

    private static void addNode(int inputData) {
        if (head == null) {
            head = new Node();
            head.data = inputData;
            head.nextNode = null;
            return;
        }
        Node curr = head;
        while (curr != null && curr.nextNode != null) {
            curr = curr.nextNode;
        }
        curr.nextNode = new Node();
        curr.nextNode.data = inputData;
        curr.nextNode.nextNode = null;
    }
}
