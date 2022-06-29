package com.practice.linkedList;

public class IntersectionSortedList {
    static Node head1,head2
            ;
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    public static void main(String[] args) {
        IntersectionSortedList list=new IntersectionSortedList();
        list.head1 = new Node(1);
        list.head1.next = new Node(2);
        list.head1.next.next = new Node(3);
        list.head1.next.next.next = new Node(4);
        list.head1.next.next.next.next = new Node(5);

        // creating second linked list
        list.head2 = new Node(2);
        list.head2.next = new Node(3);
        list.head2.next.next = new Node(4);
        list.head2.next.next.next = new Node(8);
       // printRecurringMembers(head1,head2);
        sortedIntersect(head1,head2);
    }


    static void  sortedIntersect(Node head1, Node head2)
    {

        // pointers for iterating
        Node p =head1,q = head2;
        while(p != null  &&  q != null)
        {
            if(p.data == q.data)
            {
                // add to dummy list
                System.out.print(p.data+" ");
                p = p.next;
                q = q.next;
            }
            else if(p.data < q.data)
                p = p.next;
            else
                q= q.next;
        }
    }


    private static void printRecurringMembers(Node head1, Node head2) {
        Node ptr1=head1;
        Node ptr2=head2;
        while(null != ptr1){
            while(null != ptr2){
                if(ptr1.data==ptr2.data){
                    System.out.print(ptr1.data+"->");
                }
                ptr2=ptr2.next;
            }
            ptr2=head2;
            ptr1=ptr1.next;
        }
        System.out.print("null");
    }
}
