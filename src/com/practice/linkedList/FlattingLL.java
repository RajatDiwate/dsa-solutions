package com.practice.linkedList;

public class FlattingLL {
    Node head;
    class Node{
        int data;
        Node right;
        Node down;
        Node(int data){
            this.data=data;
            this.down=null;
            this.right=null;
        }
    }
    
}
