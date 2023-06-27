import java.util.*;

public class Run {
    public static void main(String[] args) {
        SinglyLL ob = new SinglyLL();

        ob.menu();
    }

}

class SinglyLL {
    Scanner sc = new Scanner(System.in);

    class Node {
        int data;

        Node next;

        Node(int data) {
            this.data = data;
            next = null;

        }

    }

    Node first = null;

    Node top = first;

    void Addfirst(int data) {

        Node n = new Node(data);

        if (first == null) {
            first = n;
        }

        else {
            n.next = first;
            first = n;

        }
    }

    void display() {
        Node temp = first;

        while (temp != null) {
            System.out.print(temp.data + " --->");
            temp = temp.next;
        }

        System.out.print(" Null ");
    }

    void Addlast(int data) {

        Node n = new Node(data);

        if (first == null) {
            first = n;
        }

        else {

            Node temp = first;
            while (temp.next != null) {

                temp = temp.next;
            }

            temp.next = n;

        }
    }

    void menu() {
        Scanner sc = new Scanner(System.in);

        System.out.println();
        System.out.println(
                "1. for AddFirst \n2. for Add last \n3. for display \n4. for search \n5. for InsertBefore  \n6. for InsertAfter \n7. for DeleteFirst \n8. for DeleteLast \n9. for Deleting Particular value \n10. for Insert Sort \n11. for Push \n12. for DisplayPush \n13. for Pop \n14. for Delete Using Index");

        int opt = sc.nextInt();

        switch (opt) {
            case 1:
                System.out.println("enter the Value that you want to add first");
                int n = sc.nextInt();

                Addfirst(n);
                menu();
                break;

            case 2:
                System.out.println("enter the Value that you want to add last");
                int m = sc.nextInt();
                Addlast(m);
                menu();
                break;

            case 3:
                System.out.println("The values are as follows :");
                display();
                menu();

                break;

            case 4:

                search();
                menu();

                break;

            case 5:
                System.out.println("Enter the value where you want to insert before");
                int b = sc.nextInt();

                System.out.println();
                System.out.println("Enter the value that you want to store before that value");
                int w = sc.nextInt();

                insertfirst(w, b);
                menu();

                break;

            case 6:
                System.out.println("Enter the value where you want to insert After");
                int num1 = sc.nextInt();

                System.out.println();
                System.out.println("Enter the value that you want to store After that value");
                int num2 = sc.nextInt();

                insertafter(num2, num1);
                menu();

                break;

            case 7:

                deletefirst();
                menu();

                break;

            case 8:

                deletelast();
                menu();

                break;

            case 9:

                deleteParticular();
                menu();

                break;

            case 10:
                System.out.println("Enter the Value of the Number :");
                int y = sc.nextInt();

                InsertSort(y);
                menu();

                break;

            case 11:
                System.out.println("Enter the Value of the Number :");
                int yu = sc.nextInt();

                push(yu);
                menu();

                break;

            case 12:

                DisplayPush();
                menu();

                break;

            case 13:

                pop();
                menu();

                break;

            case 14:
                System.out.println("Enter the Number : ");
                int number = sc.nextInt();
                DeleteIndex(number);
                menu();

                break;

            default:
                System.out.println("Enter a  valid option");
                menu();
                break;
        }
    }

    void search() {

        System.out.println("Enter the value that you want to search");
        int s = sc.nextInt();

        Node temp = first;
        int count = 1;
        boolean ty = false;
        while (temp != null) {

            if (temp.data == s) {
                System.out.println("Match Found and it is at node :" + count);
                ty = true;
            }

            temp = temp.next;
            count++;
        }

        if (ty == false) {
            System.out.println("Match not Found in whole Linked List");
        }

    }

    void insertfirst(int data, int value) {

        Node temp = first;
        int count = 1;
        boolean ty = false;
        while (temp != null) {

            if (temp.data == value) {

                ty = true;

            }

            temp = temp.next;
            count++;
        }

        if (ty == false) {
            System.out.println("Match not Found in whole Linked List");
        }

        if (ty == true) {
            System.out.println("Match Found and it is at node :" + count);

            Node n = new Node(data);

            if (first.data == value) {
                n.next = first;
                first = n;
            }

            else {
                temp = first;

                while (temp.next.data != value) {
                    temp = temp.next;
                }

                n.next = temp.next;

                temp.next = n;

            }
        }
    }

    void insertafter(int data, int value) {

        Node temp = first;
        int count = 1;
        boolean ty = false;
        while (temp != null) {

            if (temp.data == value) {

                ty = true;

            }

            temp = temp.next;
            count++;
        }

        if (ty == false) {
            System.out.println("Match not Found in whole Linked List");
        }

        if (ty == true) {
            System.out.println("Match Found and it is at node :" + count);

            Node n = new Node(data);

            temp = first;

            while (temp.data != value) {
                temp = temp.next;
            }

            n.next = temp.next;

            temp.next = n;

        }
    }

    void deletefirst() {

        if (first == null) {
            System.out.println("Dletion not possible");
        }

        else {
            first = first.next;

            System.out.println("Deleted Succesfully");
        }

    }

    void deletelast() {

        if (first == null) {
            System.out.println("List is Empty ");

        } else if (first.next == null) {
            first = null;
        }

        else {
            Node temp = first;

            while (temp.next.next != null) {
                temp = temp.next;
            }

            temp.next = null;
        }

    }

    void deleteParticular() {
        System.out.println("Enter the value that you want to search");
        int s = sc.nextInt();
        int count = 0;
        boolean y = false;
        Node temp = first;

        while (temp != null) {

            if (temp.data == s) {
                System.out.println(s + " IS FOUND AT NODE " + count);
                y = true;
            }

            temp = temp.next;
            count++;

        }

        if (y == false) {
            System.out.println(" Not Found in List ");
        }

        else {

            if (first.data == s) {

                Node del = first;

                first = first.next;

                del.next = null;
            }

            else {
                temp = first;

                while (temp.next.data != s) {
                    temp = temp.next;
                }

                Node q = temp.next;

                temp.next = q.next;

                q.next = null;
            }

        }
    }

    void InsertSort(int data) {

        Node n = new Node(data);

        if (first == null || (first.data >= n.data)) {
            n.next = first;
            first = n;
        }

        else {
            Node cur = first;

            while (cur.next != null && cur.next.data < n.data) {
                cur = cur.next;
            }

            n.next = cur.next;

            cur.next = n;
        }

    }

    void push(int data) {
        Node n = new Node(data);

        if (top == null) {
            top = n;
        }

        else {
            n.next = top;
            top = n;
        }
    }

    void pop() {

        if (top == null) {
            System.out.println(" LIst is Empty");
        }
        Node del = top;

        top = top.next;

        del.next = null;
    }

    void DisplayPush() {

        Node temp = top;

        while (temp != null) {
            System.out.print(temp.data + " --->");
            temp = temp.next;
        }

        System.out.print(" Null ");
    }

    void DeleteIndex(int pos) {
        Node prev = null;
        Node cur = first;

        int count = 0;

        Node temp = first;

        while (temp != null) {
            count++;
            temp = temp.next;
        }

        System.out.println(" Count is : " + count);

        if (pos < 1 || pos > count) {
            System.out.println("Not-Possible");
        }

        else {

            if (pos == 1) {
                Node del = first;

                first = first.next;

                del.next = null;

            }

            else {

                while (--pos > 0) {
                    prev = cur;

                    cur = cur.next;
                }

                prev.next = cur.next;

                cur.next = null;

            }

        }
    }
}
