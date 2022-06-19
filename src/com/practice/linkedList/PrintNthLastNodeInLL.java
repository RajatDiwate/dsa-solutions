package com.practice.linkedList;


public class PrintNthLastNodeInLL {
    public static Node head;
    public static class Node{
        int data;
        Node nextNode;
    }
    public static void main(String... args){
        insertAtBeginning(25);
        insertAtBeginning(24);
        insertAtBeginning(23);
        insertAtBeginning(26);
        insertAtBeginning(28);
        printLinkedList();
        //Print Nth Node from Last
        //Present
        printNthFromLast(3);
        //notthere
        printNthFromLast(6);
        //LL is empty
        printNthFromLast(5);

    }

    private static void printNthFromLast(int nthFromLast) {
        int len=0;
        Node curr=head;
        while (curr!=null){
            curr=curr.nextNode;
            len++;
        }
        if(nthFromLast>len){
            System.out.println("LL has a size of "+ len+" so nth ele has overflown");
            return;
        }
        curr=head;
        for (int i = 0; i < len-nthFromLast; i++) {
            curr=curr.nextNode;
        }
        System.out.println(curr.data+" ");
        return;
    }

    private static  void printLinkedList(){
        Node curr=head;
        while(curr!=null){
            System.out.print(curr.data+ " ");
            curr=curr.nextNode;
        }
        System.out.println();
    }

    private static void insertAtBeginning(int inputData) {
        Node newNode=new Node();
        newNode.data=inputData;
        newNode.nextNode=head;
        head=newNode;
    }

}
