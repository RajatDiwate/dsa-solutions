package com.practice.linkedList;

public class LinkedList_01Reverse {
    public static Node head;

    public static class Node {
        Node(int data, Node nextNode) {
            this.data = data;
            this.nextNode = nextNode;
        }

        int data;
        Node nextNode;
    }

    public static void main(String[] args) {
        addAnElement(2);
        addAnElement(3);
        addAnElement(4);
        addAnElement(55);
        addAnElement(6);
        printAllEle();

        //Reverse a LL
        reverseLL();
        printAllEle();
    }

    private static void reverseLL() {
        Node curr=head;
        Node prev=null;
        Node nextNode;
        while (curr!=null ){
            nextNode=curr.nextNode;
            curr.nextNode=prev;
            prev=curr;
            curr=nextNode;
        }
        head=prev;
    }

    private static void printAllEle() {
        if(head==null){
            System.out.println("ll is empty");
            return;
        }
        Node curr=head;
        while(curr!=null ){
            System.out.print(curr.data+" ");
            curr=curr.nextNode;
        }
        System.out.println();
    }

    private static void addAnElement(int inputData) {
        Node current = head;
        while(current!=null && current.nextNode!=null){
            current=current.nextNode;
        }
        if(current!=null) {
            current.nextNode = new Node(inputData, null);
            return;
        }
        head=new Node(inputData, null);
    }
}
