
class LinkList {
    class Node {
        int data;
        Node link;

        public Node(int data) {
            this.data = data;
            this.link = null;
        }
    }

    Node first = null;

    void addFirst(int x) {
        Node newNode = new Node(x);
        if (first != null) {
            newNode.link = first;
        }
        first = newNode;
    }

    void addLast(int x) {
        Node newNode = new Node(x);
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

    LinkList append(LinkList ll1, LinkList ll2) {
        Node temp = ll1.first;
        if(temp != null) {
            while (temp.link != null) {
                temp = temp.link;
            }
            temp.link = ll2.first;
            return ll1;
        } else {
            return ll2;
        }
    }

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
}

class SinglyLinkList {
    public static void main(String[] args) {
        LinkList ll1 = new LinkList();
        LinkList ll2 = new LinkList();
        ll1.addLast(10);
        ll1.addLast(20);
        ll1.addLast(30);
        ll1.addLast(40);
        ll2.addLast(50);
        ll2.addLast(60);
        ll2.addLast(70);
        ll2.addLast(80);

        ll1 = ll1.append(ll1, ll2);

        ll1.display();

        ll1.insertOrder(35);
        ll1.display();
        
        //   ll.addBeforeValue(15, 20);
        //   ll.display();
        //   ll.addBeforeValue(5, 10);
        //   ll.display();
        //   ll.addBeforeValue(45, 50);
        //   ll.insertOrder(66);
        //   ll.display();
        //   ll.insertOrder(37);
        //   ll.display();
        //   ll.insertOrder(3);
        //   ll.display();
        //   ll.delete(3);
        //   ll.display();
        //   ll.delete(20);
        //   ll.display();
        //   ll.delete(37);
        //   ll.display();
         
    }
}