import java.util.*;

class SinglyLL{
    class Node {
        int data;
        Node link;

        Node(int x){
            data = x;
            link = null;
        }
    }
    Node first = null;

    void addFirst(int data){            // to take value from user
        Node newNode = new Node(data);  // initialize the value in the constructor
        if(first == null){              // if first points to null then
            first = newNode;            // then newNode will be assigned to first!
        }
        else{
            newNode.link = first;       // if first doesn't points to null then newNode's link will linked to First!
            first = newNode;            // hence first will be the newNode
        }
    }

    void addLast(int data){
        Node newNode = new Node(data);
        Node temp = first;              // create a temp refrence variable which points to first for now!
        if(first == null){
            first = newNode;
        }
        else{
            while(temp.link != null){   // if temp's node link is not null 
                temp = temp.link;       // then temp will move forward till it's link is not null!
            }
            temp.link = newNode;        // at last temp node's link will be newNode
        }
    }

    void insertOrder(int x) {
        Node newNode = new Node(x);
        if (first == null) {
            first = newNode;
        } else if (x <= first.data) {
            newNode.link = first;
            first = newNode;
        } else {
            Node temp = first;
            while (temp.link != null && temp.link.data <= x) {
                temp = temp.link;
            }
            if (temp.link != null) {
                newNode.link = temp.link;
                temp.link = newNode;
            } else {
                temp.link = newNode;
            }
        }
    }

    void delete(int value) {
        if (first == null) {
            System.out.println("Link-List is Empty");
        } else if (first.data == value) {
            System.out.println("Deleted Element : " + first.data);
            first = first.link;
        } else {
            Node temp = first;
            while (temp.link != null && temp.link.data != value) {
                temp = temp.link;
            }
            if (temp.link != null) {
                System.out.println("Deleted Element : " + temp.link.data);
                temp.link = temp.link.link;
            } else {
                System.out.println("Value Not found");
            }
        }
    }

    // LinkList append(LinkList ll1, LinkList ll2) {
    //     Node temp = ll1.first;
    //     if(temp != null) {
    //         while (temp.link != null) {
    //             temp = temp.link;
    //         }
    //         temp.link = ll2.first;
    //         return ll1;
    //     } else {
    //         return ll2;
    //     }
    // }

    void display() {
        if (first == null) {
            System.out.println("Link-List is Empty");
        } else {
            for (Node i = first; i != null; i = i.link) {
                System.out.print(i.data + " --> ");
            }
            System.out.print("null");
            System.out.println();
        }
    }
    public static void main(String[] args) {
        SinglyLL s = new SinglyLL();   
    }
}