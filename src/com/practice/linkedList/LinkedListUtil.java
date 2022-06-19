package com.practice.linkedList;

public class LinkedListUtil {
    public static class Node{
        int data;
        Node nextNode;
    }

    static void printLL(Node head){
        Node curr=head;
        while(curr!=null){
            System.out.print(curr.data+" ");
            curr=curr.nextNode;
        }
        System.out.println();
    }
     static Node addAtStart(Node head,int inputData) {
        Node newNode=new Node();
        newNode.data=inputData;
        newNode.nextNode=head;
        head=newNode;
        return head;
    }
}
