package com.practice.linkedList;

public class PairwiseSwap {
    public static Node head;

    public static class Node {
        int data;
        Node nextNode;
    }

    public static void main(String[] args) {

        insertAtEnd(1);
        insertAtEnd(2);
        insertAtEnd(3);
        insertAtEnd(4);
//        insertAtEnd(4);
        insertAtEnd(3);
        insertAtEnd(2);
        insertAtEnd(1);
        // insertAtEnd(64);
        printLinkedList();
        //--Pairwise Swap;
        //pairWiseSwapByData();
        //pairwiseSwapByNode();

//--Rotate a LL by n
        //      rotateLLByN(4);
        //     printLinkedList();
//-Palindrome
        checkIfLLIsPlaindrome(head);
//        //
        printLinkedList();
    }

    private static void checkIfLLIsPlaindrome(Node head) {
        Node slowPtr = head;
        Node fastPtr = slowPtr;
        Node temp = null;
        Node midNode = null;
        Node head2 = null;
        while (fastPtr != null && fastPtr.nextNode != null) {
            temp = slowPtr;
            slowPtr = slowPtr.nextNode;
            fastPtr = fastPtr.nextNode.nextNode;
        }
        System.out.println("middleNode :" + slowPtr.data);
        if (fastPtr != null) {
            midNode = slowPtr;
            slowPtr = slowPtr.nextNode;
        }
        head2 = slowPtr;
        temp.nextNode = null;
        head2 = reverseLinkedList(head2);
        boolean flag = compareTwoLL(head, head2);
        System.out.println("Is Palindrome::" + flag);
        head2 = reverseLinkedList(head2);

        if (midNode != null) {
            temp.nextNode = midNode;
            midNode.nextNode = head2;
        } else {
            temp.nextNode = head2;
        }
    }

    private static boolean compareTwoLL(Node head, Node head2) {
        Node temp1 = head;
        Node temp2 = head2;
        while (temp1 != null && temp2 != null) {
            if (temp1.data == temp2.data) {
                temp1 = temp1.nextNode;
                temp2 = temp2.nextNode;

            } else {
                return false;
            }
        }
        if (temp1 == null && temp2 == null) {
            return true;
        }


        return false;
    }

    static Node reverseLinkedList(Node reverse) {
        Node curr = reverse;
        Node currentOfNext;
        Node prev = null;
        while (curr != null) {
            currentOfNext = curr.nextNode;
            curr.nextNode = prev;
            prev = curr;
            curr = currentOfNext;
        }
        reverse = prev;
        return reverse;
    }

    private static void rotateLLByN(int shiftByn) {
        Node curr = head;
        int len = 1;
        while (len <= shiftByn && null != curr && null != curr.nextNode) {
            curr = curr.nextNode;
            len++;
        }
        if (curr == null)
            return;

        Node kthNode = curr;

        while (curr.nextNode != null) {
            curr = curr.nextNode;
        }

        curr.nextNode = head;
        head = kthNode.nextNode;
        kthNode.nextNode = null;
    }

    private static void pairwiseSwapByNode() {
        if (head == null || head.nextNode == null) {
            System.out.println("LL has only One node");
            return;
        }
        Node curr = head;
        Node currOfNext = curr.nextNode;
        Node prev = null;
        int len = 0;
        while (curr != null && curr.nextNode != null) {
            len++;
            curr.nextNode = currOfNext.nextNode;
            currOfNext.nextNode = curr;
            if (len == 1) {
                head = currOfNext;
            } else {
                prev.nextNode = currOfNext;
            }
            prev = curr;
            curr = curr.nextNode;
            currOfNext = curr.nextNode;
        }
    }

    private static void pairWiseSwapByData() {
        Node curr = head;

        /* Traverse only till there are atleast 2 nodes left */
        while (curr != null && curr.nextNode != null) {

            /* Swap the data */
            int k = curr.data;
            curr.data = curr.nextNode.data;
            curr.nextNode.data = k;
            curr = curr.nextNode.nextNode;
        }
    }

    private static void printLinkedList() {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.nextNode;
        }
        System.out.println();
    }

    private static void insertAtEnd(int inputData) {
        Node newNode = new Node();
        newNode.data = inputData;
        newNode.nextNode = null;
        if (head == null) {
            head = newNode;
            return;
        }
        Node curr = head;
        while (curr != null && curr.nextNode != null) {
            curr = curr.nextNode;
        }
        curr.nextNode = newNode;
    }

}
