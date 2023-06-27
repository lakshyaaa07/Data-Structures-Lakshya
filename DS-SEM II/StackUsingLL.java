//  STACK USING LINK-LIST

class Stack {

    class Node {
        int data;
        Node link;

        Node(int x) {
            data = x;
        }
    }

    Node top = null;

    void push(int x) {
        Node newnode = new Node(x);
        newnode.link = top;
        top = newnode;
    }

    void pop(){
        if(top==null){
            System.out.println("STACK IS EMPTY");
        }
        else{
            System.out.println("DELETED NODE IS:-"+top.data);
            top=top.link;
        }
    }

    void display(){
        Node temp=top;
        while(temp!=null){
            System.out.println(temp.data);
            temp=temp.link;
        }
    }

}

public class StackUsingLL {
    public static void main(String[] args) {
        Stack sll=new Stack();
        sll.push(10);
        sll.push(20);
        sll.push(30);
        sll.push(40);
        sll.display();
        sll.pop();
        sll.pop();
        sll.display();

        
    }
}
