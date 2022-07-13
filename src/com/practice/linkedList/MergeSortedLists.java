package com.practice.linkedList;

public class MergeSortedLists {
    Node head;

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
        while (null != curr) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MergeSortedLists list1 = new MergeSortedLists();
        list1.push(10);
        list1.push(9);
        list1.push(8);
        list1.push(7);
        list1.push(6);
        list1.print();
        System.out.println("---------------");
        MergeSortedLists list2 = new MergeSortedLists();
        list2.push(5);
        list2.push(4);
        list2.push(3);
        list2.push(2);
        list2.push(1);
        list2.print();
        System.out.println("---------------");
        list1.head = new MergeSortedLists().sortedMerge(list1.head, list2.head);
        list1.print();
        System.out.println("---------------");
    }

    private Node sortedMerge(Node head1, Node head2) {
        Node tail = new Node(0);
        Node curr = tail;
        while (true) {
            if (head1 == null) {
                curr.next = head2;
                break;
            }
            if (head2 == null) {
                curr.next = head1;
                break;
            }

            if (head1.data <= head2.data) {
                curr.next = head1;
                head1 = head1.next;
            } else {
                curr.next = head2;
                head2 = head2.next;
            }
            curr = curr.next;
        }
        return tail.next;
    }
}
