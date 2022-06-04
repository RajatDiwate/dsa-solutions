package com.java.datastructure.linkedlist.singly;

public class SinglyLinkedList {
    public static Node head;

    SinglyLinkedList() {
        head = null;
    }

    public static class Node {
        int data;
        Node nextNode;

        Node(int data, Node nextNode) {
            this.nextNode = nextNode;
            this.data = data;
        }
    }

    public static void main(String[] args) {
        printLinkedList();
        insertAtBeginning(2);
        insertAtBeginning(3);
        insertAtBeginning(4);
        insertAtBeginning(76);
        insertAtBeginning(27);
        printLinkedList();
        insertAtLast(34);
        insertAtLast(36);
        insertAtLast(37);
        printLinkedList();
        insertAfterData(27, 58);
        printLinkedList();
        insertBeforeData(27, 66);
        printLinkedList();

        deleteNode(636);
        printLinkedList();
        reverseLinkList();
        printLinkedList();
        findMiddle();

        // find loop, remove loop, find length of loop
        //Creating a loop
        Node lastNode = findExistingNode(66);
        Node middleNode = findExistingNode(3);

        initializeLoop(lastNode, middleNode);
        //Detect a Loop
        Node node = detectLoop();
        int loopLen = findLengthOfLoop(node);
        removeLoop(loopLen);

        printLinkedList();

        //PrintLL without reversing
        Node curr = head;
        printLinkedListWithoutReversal(curr);
        System.out.println();
    }

    private static void printLinkedListWithoutReversal(Node node) {
        if (node == null) {
            return;
        }
        printLinkedListWithoutReversal(node.nextNode);
        System.out.print(node.data + " ");
    }

    private static void removeLoop(int loopLen) {
        Node curr = head;
        Node nodeAtDist = findNodeAtDistance(loopLen);
        while (nodeAtDist.nextNode != curr) {
            curr = curr.nextNode;
            nodeAtDist = nodeAtDist.nextNode;
        }
        nodeAtDist.nextNode = null;
    }

    private static Node findNodeAtDistance(int loopLen) {
        Node curr = head;
        loopLen--;
        while (loopLen != 0) {
            curr = curr.nextNode;
            loopLen--;
        }
        System.out.println("ele found" + curr.data);
        return curr;
    }

    private static int findLengthOfLoop(Node node) {
        if (node == null)
            return 0;
        Node curr = node.nextNode;
        int len = 1;
        while (node != curr) {
            curr = curr.nextNode;
            len++;
        }
        System.out.println("Length of Loop is :" + len);
        return len;

    }

    private static Node detectLoop() {
        Node slow = head;
        Node fast = head.nextNode;
        while (fast != null && fast.nextNode != null && slow != fast) {
            slow = slow.nextNode;
            fast = fast.nextNode.nextNode;
        }
        if (slow != null && slow == fast) {
            System.out.println("Loop detected at :" + fast.data);
            return slow;
        }
        System.out.println("Loop doesn't exists in LinkedList.");
        return null;
    }

    private static void initializeLoop(Node lastNode, Node middleNode) {
        lastNode.nextNode = middleNode;
    }

    private static Node findExistingNode(int inputData) {
        Node curr = head;
        while (curr != null && curr.data != inputData) {
            curr = curr.nextNode;
        }
        if (curr == null) {
            System.out.println("Element not found");
            return null;
        }
        System.out.println(curr.data);
        return curr;
    }

    private static void findMiddle() {
        if (head == null) {
            System.out.println("LL is empty");
            return;
        }
        Node slow = head;
        if (slow.nextNode == null) {
            System.out.println(slow.data);
            return;
        }
        Node fast = head.nextNode;
        while (fast != null && fast.nextNode != null) {
            slow = slow.nextNode;
            fast = fast.nextNode.nextNode;
        }
        System.out.println("Middle Ele=" + slow.data);

    }

    private static void findMiddleBrut() {
        if (head == null) {
            System.out.println("LL is empty");
            return;
        }
        Node current = head;
        int count = 0;
        while (current != null && current.nextNode != null) {
            current = current.nextNode;
            count++;
        }
        int tempCount = 0;
        Node temp = head;
        while (count / 2 != tempCount && temp != null && temp.nextNode != null) {
            temp = temp.nextNode;
            tempCount++;
        }
        System.out.println("Middle" + temp.data);
    }

    private static void reverseLinkList() {
        Node current = head;
        Node prev = null;
        Node next = null;
        while (current != null) {
            next = current.nextNode;
            current.nextNode = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }


    private static void deleteNode(int delEle) {
        Node current = head;
        if (current != null && current.data == delEle) {
            head = current.nextNode;
            return;
        }
        Node temp = null;
        while (current != null && current.data != delEle) {
            temp = current;
            current = current.nextNode;
        }
        if (current == null) {
            System.out.println("No such node exists : " + delEle);
            return;
        }
        temp.nextNode = current.nextNode;
    }


    private static void insertBeforeData(int data, int inputData) {
        Node currentNode = head;
        Node prev = null;
        while (currentNode.nextNode != null && currentNode.data != data) {
            prev = currentNode;
            currentNode = currentNode.nextNode;
        }
        if (currentNode.nextNode == null && currentNode.data != data) {
            System.out.println("Element Not Found");
            return;
        }
        if (currentNode == head) {
            head = new Node(inputData, head);
            return;
        }
        prev.nextNode = new Node(inputData, prev.nextNode);
    }


    private static void insertAfterData(int data, int inputData) {
        if (null == head) {
            System.out.println("LL is empty");
            return;
        }
        Node currentNode = head;
        while (currentNode.nextNode != null && currentNode.data != data) {
            currentNode = currentNode.nextNode;
        }
        if (currentNode.nextNode == null && currentNode.data != data) {
            System.out.println("Element Not Found");
            return;
        }
        currentNode.nextNode = new Node(inputData, currentNode.nextNode);
    }

    private static void insertAtBeginning(int inputData) {
        head = new Node(inputData, head);
    }


    private static void insertAtLast(int inputData) {
        if (null == head) {
            head = new Node(inputData, null);
        }
        Node currentNode = head;
        while (currentNode.nextNode != null) {
            currentNode = currentNode.nextNode;
        }
        currentNode.nextNode = new Node(inputData, null);
    }

    private static void printLinkedList() {
        if (head == null) {
            System.out.println("LL is empty");
            return;
        }
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.nextNode;
        }
        System.out.println();
        System.out.println("--------------");
    }


}
