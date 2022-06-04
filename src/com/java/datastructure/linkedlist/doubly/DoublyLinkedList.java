package com.java.datastructure.linkedlist.doubly;

public class DoublyLinkedList {
    public static Node head;

    public static class Node {
        int data;
        Node nextNode;
        Node prevNode;
    }

    public static void main(String[] args) {
        addElementAtBeggining(23);
        insertAfterNode(13, 45);
        insertAtEnd(34);
        printDoublyLL();
        printDoublyLLReverse();
    }

    private static void printDoublyLLReverse() {
        Node lastNode = getLastNode();

    }

    private static Node getLastNode() {
        Node current = head;
        while (current != null && current.nextNode != null) {
            current = current.nextNode;
        }
        return current;
    }

    private static void printDoublyLL() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.nextNode;
        }
        System.out.println("");

    }

    private static void addElementAtBeggining(int inputData) {
        Node newNode = new Node();
        newNode.data = inputData;
        head.prevNode = newNode;
        head = newNode;
    }

    private static void insertAtEnd(int inputData) {

    }

    private static void insertAfterNode(int inputDate, int element) {
    }


}
