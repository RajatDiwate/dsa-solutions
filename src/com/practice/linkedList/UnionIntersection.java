package com.practice.linkedList;

 class UnionIntersection {
     Node head;

     class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    private void print(){
        Node curr=head;
        while(curr!=null){
            System.out.print(curr.data+" ");
            curr=curr.next;
        }
        System.out.println();
    }
    void push(int inputData){
        Node curr=new Node(inputData);
        curr.next=head;
        head=curr;
    }
    public static void main(String[] args) {
        UnionIntersection  llist1 =new UnionIntersection();
        UnionIntersection  llist2 =new UnionIntersection();
        /*create a linked list 10->15->4->20 */
        llist1.push(20);
        llist1.push(4);
        llist1.push(15);
        llist1.push(10);

        /*create a linked list 8->4->2->10 */
        llist2.push(10);
        llist2.push(2);
        llist2.push(4);
        llist2.push(8);

        llist1.print();
        llist2.print();
        //10 15 4 20
        //8 4 2 10

        //Find Intersection--> 10 4
        findIntersectionFromTwoLL(llist1.head,llist2.head);
        UnionIntersection unin = new UnionIntersection();
        //find Union --> 8,4,2,10,15,20
        unin.findUnionFromTwoLL(llist1.head,llist2.head);
        unin.print();
    }




    private void findUnionFromTwoLL(Node head1, Node head2) {
        Node ptr1=head1;
        Node ptr2=head2;
        while(ptr1!=null){
            push(ptr1.data);
            ptr1=ptr1.next;
        }

        while(ptr2!=null){
           if(!isPresent(head,ptr2.data)){
                push(ptr2.data);
           }
            ptr2=ptr2.next;
        }

    }

    private boolean isPresent(Node head, int data){
        Node curr=head;
        while(curr!=null){
            if(curr.data==data){
                return true;
            }
            curr=curr.next;
        }
         return false;
    }

    private static void findIntersectionFromTwoLL(Node head1, Node head2) {
         Node ptr1=head1;
         Node ptr2=head2;
         while (ptr1!=null){
             while(ptr2!=null){
                 if(ptr1.data==ptr2.data){
                     System.out.print(ptr1.data+" ");
                 }
                 ptr2=ptr2.next;
             }
             ptr2=head2;
             ptr1=ptr1.next;
         }
        System.out.println();
    }
}
