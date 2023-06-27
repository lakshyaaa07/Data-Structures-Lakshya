class SinglyLL {
    class Node {
        int data;
        Node link;

        Node(int data) {
            this.data = data;
            link = null;
        }
    }

    Node first = null;
    
    void addfirst(int data) {
        Node newNode = new Node(data);

        if (first != null) {
            newNode.link = first;
        }
        first = newNode;

    }

    void addLast(int data) {
        Node newNode = new Node(data);
        if (first == null) {
            first = newNode;
        } else {
            Node temp = first;
            while (temp.link != null) {
                temp = temp.link;
            }
            temp.link = newNode;
        }
    }

    void addBeforevalue(int data, int value) {
        Node newNode = new Node(data);
        Node temp = first;
        if (first.data == value) {
            newNode.link = first;
            first = newNode;
        }

        else {
            while (temp.link != null && temp.link.data != value) {
                temp = temp.link;
            }
            if (temp.link == null && temp.data != value) {
                System.out.println("Value not found");
            } else {
                newNode.link = temp.link;
                temp.link = newNode;
            }
        }
    }

    void deleteFirst() {
        if (first == null) {
            System.out.println("Link list is empty");
        } else {
            System.out.println("Delted element: " + first.data);
            first = first.link;
        }
    }

    void deleteLast() {
        if (first == null) {
            System.out.println("Link list is empty");
        } else if (first.link == null) {
            System.out.println("Deleted element" + first.data);
            first = null;
        } else {
            Node temp = first;
            while (temp.link.link != null) {
                temp = temp.link;
            }
            System.out.println("Deleted element: " + temp.link.data);
            temp.link = null;
        }
    }

    void DeleteValue(int x){
        if(first==null){
            System.out.println("LINKLIST IS EMPTY");
        }
        else{
            if(first.data==x){
                System.out.println("Deleted Element is: "+first.data);
                first=first.link;
            }
            else{
                Node temp=first;
                while(temp.link!=null&& temp.link.data!=x){
                    temp=temp.link;
                }
                if(temp.link!=null){
                    System.out.println("Deleted Element is: "+temp.link.data);
                    temp.link=temp.link.link;
                }
                else{
                    System.out.println("VALUE NOT FOUND");
                }
            }
        }

     }

     void insertOrder(int x){
      
        Node newnoNode=new Node(x);
        if(first==null){
            first=newnoNode;
        }
        else if(x<=first.data){
            newnoNode.link=first;
            first=newnoNode;
        }
        else{
            Node temp=first;
            while(temp.link!=null&&x>=temp.link.data){
                temp=temp.link;
            }
            newnoNode.link=temp.link;
            temp.link=newnoNode;
        }
     }

    void display() {
        Node temp = first;
        while (temp != null) {
            System.out.print(temp.data + "--->");
            temp = temp.link;
        }
        System.out.println("NULL");
    }
}

public class SinglyLLExp {
    public static void main(String[] args) {

        SinglyLL ll = new SinglyLL();

        ll.addLast(50);
        ll.addfirst(40);
        ll.addBeforevalue(35, 40);
        ll.addBeforevalue(35, 40);
        ll.insertOrder(30);
        ll.insertOrder(55);
        ll.display();
    }
}
