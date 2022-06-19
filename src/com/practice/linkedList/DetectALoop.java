package com.practice.linkedList;

import java.util.HashMap;
import java.util.Map;

public class DetectALoop {
    public static LinkedListUtil.Node head;

    public static void main(String[] args) {


        head = LinkedListUtil.addAtStart(head, 5);
        head = LinkedListUtil.addAtStart(head, 6);
        head = LinkedListUtil.addAtStart(head, 7);
        head = LinkedListUtil.addAtStart(head, 8);
        head = LinkedListUtil.addAtStart(head, 55);
        head = LinkedListUtil.addAtStart(head, 46);
        head = LinkedListUtil.addAtStart(head, 4);
        head = LinkedListUtil.addAtStart(head, 22);
        head = LinkedListUtil.addAtStart(head, 53);
        LinkedListUtil.printLL(head);
        LinkedListUtil.Node node = findExistingNode(46);
        createALoop(node);
        detectLoopWithHashMap();
        LinkedListUtil.printLL(head);
        System.out.println("-------------");
        LinkedListUtil.Node node2 = findExistingNode(46);
        createALoop(node2);
      //  LinkedListUtil.printLL(head);
        LinkedListUtil.Node node1 = detectLoopTwoPointer();
        System.out.println("looop debug:"+node1.data);
        int lengthOfLoop = findLengthOfLoop(node1);
        removeloop(lengthOfLoop);
        LinkedListUtil.printLL(head);
    }

    private static void removeloop(int lengthOfLoop) {
        LinkedListUtil.Node curr = head;
        LinkedListUtil.Node nodeAtDist = findANodeAtDistance(lengthOfLoop);
        System.out.println("nodeAtDist.data:" + nodeAtDist.data);
        //66 53 22 4 46 55 8 7 6 5 4
        while (nodeAtDist.nextNode != curr) {
           // System.out.println(curr.data + "::" + nodeAtDist.data);
            curr = curr.nextNode;
            nodeAtDist = nodeAtDist.nextNode;
        }
        nodeAtDist.nextNode = null;

    }

    private static int findLengthOfLoop(LinkedListUtil.Node node1) {
        if (node1 == null) {
            System.out.println("Loop doesn't exists.");
            return 0;
        }
        LinkedListUtil.Node curr = node1.nextNode;
        int len = 1;
        while (curr != node1) {
            len++;
            curr = curr.nextNode;
        }
        System.out.println("total len of loop:" + len);
        return len;

    }

    private static LinkedListUtil.Node detectLoopTwoPointer() {
        if(head == null) {
            System.out.println("LinkedList is empty");
            return null;
        }
        LinkedListUtil.Node slowPtr = head;
        LinkedListUtil.Node fastPtr = head.nextNode;
        while (fastPtr != null && fastPtr.nextNode != null && fastPtr != slowPtr) {
            slowPtr = slowPtr.nextNode;
            fastPtr = fastPtr.nextNode.nextNode;
        }
        if (slowPtr != null && fastPtr == slowPtr) {
            System.out.println("Loop Detected at: " + fastPtr.data);
            return slowPtr;
        }
        System.out.println("Loop doesn't exists in LinkedList.");
        return null;

    }

    private static void detectLoopWithHashMap() {
        Map<LinkedListUtil.Node, Integer> hashMap = new HashMap<>();
        LinkedListUtil.Node curr = head;
        LinkedListUtil.Node prev = null;
        while (curr != null) {
            if (hashMap.containsKey(curr)) {
                System.out.println("Loop Detected:" + prev.data);
                prev.nextNode = null;
                break;
            } else {
                hashMap.put(curr, 1);
            }
            prev = curr;
            curr = curr.nextNode;
        }
    }


    private static void createALoop(LinkedListUtil.Node node) {
        LinkedListUtil.Node curr = node;
        while (curr.nextNode != null) {
            curr = curr.nextNode;
        }
        curr.nextNode = node;
    }

    private static LinkedListUtil.Node findANodeAtDistance(int distance) {
        LinkedListUtil.Node current = head;
        distance--;
        while (distance != 0) {
            distance--;
            current = current.nextNode;
        }
        return current;
    }
    private static LinkedListUtil.Node findExistingNode(int existingData) {
        LinkedListUtil.Node current = head;
        while(current != null && current.data != existingData) {
            current = current.nextNode;
        }
        return current;
    }

}
