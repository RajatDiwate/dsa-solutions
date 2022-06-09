package com.practice.linkedList;
//Find the middle of a given linked list
public class FindMiddleEleLL {
    public static Node head;
    public static class Node{
        int data;
        Node nextNode;
    }

    public static void main(String[] args) {
        addAtStart(6);
        addAtStart(7);
        addAtStart(8);
        addAtStart(3);
        addAtStart(4);
        addAtStart(6);
        addAtStart(7);
        addAtStart(8);
        printLL();
        findMiddleEle();
    }

    private static void findMiddleEle() {
        Node slowPtr=head;
        Node fastPtr=slowPtr.nextNode;
        while(fastPtr!=null && fastPtr.nextNode!=null){
            slowPtr= slowPtr.nextNode;
            fastPtr=fastPtr.nextNode.nextNode;
        }
        System.out.println(slowPtr.data);
    }


    static void printLL(){
        Node curr=head;
        while(curr!=null){
            System.out.print(curr.data+" ");
            curr=curr.nextNode;
        }
       System.out.println();
    }
    private static void addAtStart(int inputData) {
            Node newNode=new Node();
            newNode.data=inputData;
            newNode.nextNode=head;
            head=newNode;

    }
}
