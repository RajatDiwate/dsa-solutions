package com.practice.linkedList;

import static com.practice.linkedList.LinkedListUtil.*;

public class CommonNode {
    private static Node head1;
    private static Node head2;

    public static void main(String[] args) {
        head1 = addAtEnd(head1, 3);
        head1 = addAtEnd(head1, 6);
        head1 = addAtEnd(head1, 9);
        head1 = addAtEnd(head1, 15);
        head1 = addAtEnd(head1, 30);
        head2 = addAtEnd(head2, 10);

        head2 = addAtEnd(head2, 15);
        head2 = addAtEnd(head2, 30);
        printLL(head1);
        printLL(head2);
        //getIntersectionBrutForce(head1, head2);
        getIntersectionOptimized1(head1, head2);

    }

    private static void getIntersectionOptimized1(Node head1, Node head2) {
        int len1 = getLength(head1);
        int len2 = getLength(head2);
        int data = 0;
        if (len1 > len2) {
            System.out.println(len1 + " :" + len2);
            data = getMatchingNode(len1 - len2, head1, head2);
        }else{
            data = getMatchingNode(len2 - len1, head2, head1);
        }

        System.out.println("Matching Node is:" + data);

    }

    private static int getMatchingNode(int difference, Node head1, Node head2) {
        Node ptr1 = head1;
        Node ptr2 = head2;
        for (int i = 0; i < difference; i++) {
            if (ptr1 == null) {
                return -1;
            }
            ptr1 = ptr1.nextNode;
        }
        while (null != ptr1 && null != ptr2){
            if(ptr1.data==ptr2.data){
                return ptr1.data;
            }
            ptr1=ptr1.nextNode;
            ptr2=ptr2.nextNode;
        }
        return -1;
    }

    private static int getLength(Node node) {
        int length = 0;
        Node curr = node;
        while (curr != null) {
            curr = curr.nextNode;
            length++;
        }
        return length;
    }


    private static Node getIntersectionBrutForce(Node head1, Node head2) {
        Node ptr1 = head1;
        Node ptr2 = head2;
        int len = 0;
        Node node = null;
        while (null != ptr1) {
            while (null != ptr2) {
                if (ptr1.data == ptr2.data) {
                    System.out.println("Duplicate Node is:" + ptr1.data);
                    return ptr1;
                }
                ptr2 = ptr2.nextNode;
            }
            ptr2 = head2;
            ptr1 = ptr1.nextNode;
        }
        return node;

    }


}
