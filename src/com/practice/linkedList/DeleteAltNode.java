package com.practice.linkedList;

public class DeleteAltNode {
    static Node head;

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    public void push(int inputData) {
        Node node = new Node(inputData);
        node.next = head;
        head = node;
    }


    public static void main(String[] args) {
        DeleteAltNode list = new DeleteAltNode();
        list.push(5);
        list.push(4);
        list.push(3);
        list.push(2);
        list.push(1);
        list.print();
        deleteAltNodes2();
        list.print();


    }

    private static void deleteAltNodes2() {
        if(head==null){
            System.out.println("LL is Empty");
            return;
        }
        Node curr = head;
        while (curr != null && curr.next != null) {
            curr.next=curr.next.next;
            curr=curr.next;
        }

    }


    private static void deleteAltNodes() {
        Node curr = head;
        boolean flag = false;
        Node prev = null;
        while (curr != null) {
            if (flag) {
                prev.next = curr.next;
            }
            flag = !flag;
            prev = curr;
            curr = curr.next;
        }
    }

    private void print() {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

}
