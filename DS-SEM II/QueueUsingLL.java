class Queue {

    class Node {
        int data;
        Node link;

        Node(int x) {
            data = x;
        }
    }
    
    Node Front=null;
    Node Rear=null;


    void enque(int x){
        Node newnoNode=new Node(x);
        if(Rear==null){
            Front=Rear=newnoNode;
        }
        else{
            Rear.link=newnoNode;
            Rear=Rear.link;
        }
    }

    void deque(){
        if(Front==null){
            System.out.println("QUEUE IS EMPTY!!");
        }
        else{
            System.out.println("DELETED ELEMENT IS"+Front.data);
            Front=Front.link;


        }
    }

    void display(){
        Node temp=Front;
        while(temp!=Rear.link){
            System.out.print(temp.data+" ");
            temp=temp.link;
        }
        System.out.println();
    }

}

public class QueueUsingLL {
    public static void main(String[] args) {
        Queue qu=new Queue();
        qu.enque(10);
        qu.enque(20);
        qu.enque(30);
        qu.enque(40);
        qu.display();
        qu.deque();
        qu.deque();
        qu.display();
        qu.deque();
        qu.deque();
        qu.deque();

        qu.display();
    }
}


