package com.practice.linkedList;

public class SumTwoLinkedList {
    Node head, result;
    int carry;

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }

    }


    private void push(int inputData) {
        Node newNode = new Node(inputData);
        newNode.next = head;
        head = newNode;
    }

    private void print() {
        Node curr = head;
        System.out.print(" ");
        while (null != curr) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SumTwoLinkedList list1 = new SumTwoLinkedList();
        list1.push(5);
        list1.push(9);
        list1.push(8);
        list1.push(6);
        list1.print();
        System.out.println("+");
        SumTwoLinkedList list2 = new SumTwoLinkedList();
        list2.push(5);
        list2.push(4);
        list2.push(3);
        list2.push(2);
        list2.push(1);
        list2.print();
        System.out.println("---------------");
        SumTwoLinkedList list3 = new SumTwoLinkedList();
        //if two list are equal
       // list3.calculateSumByCarryMethod(list1.head, list2.head);
        list3.calculateSumNonEqualList(list1.head, list2.head);

        list3.printResult(list3.result);
    }

    private void printResult(Node result) {
        Node curr = result;
        System.out.print(" ");
        while (null != curr) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }

    }

    private void calculateSumByCarryMethod(Node head1, Node head2) {
        if (null == head1) {//any one is null as both size are same
            return;
        }
        calculateSumByCarryMethod(head1.next, head2.next);
        int sum = head1.data + head2.data + carry;
        carry = sum / 10;
        sum = sum % 10;
        pushSum(sum, 3);
    }

    private void pushSum(int sum, int i) {
        Node newNode = new Node(sum);
        if (i == 3) {
            newNode.next = result;
            result = newNode;
        }
    }

    private void calculateSumNonEqualList(Node head1,Node head2){
          int len1=getLength(head1);
          int len2=getLength(head2);

        if(len1>len2){
            //equal by adding node at front
           int diff=len1-len2;
            head2=addZerosAtStart(head2,diff);
        }else if(len2>len1){
            int diff=len2-len1;
           head1= addZerosAtStart(head1,diff);
        }
        calculateSumByCarryMethod(head1,head2);
    }

    private Node addZerosAtStart(Node head2, int diff) {
        Node newNode=new Node(0);
        while(diff-- >0){
            newNode.next=head2;
            head2=newNode;
        }
        return head2;
    }

    private int getLength(Node head) {
        Node curr=head;
        int len=0;
        while(null != curr){
            len++;
            curr=curr.next;
        }
        return len;
    }

}
