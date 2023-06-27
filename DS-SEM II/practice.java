//linked list
class SinglyLList{
    class Node{
        int data;
        Node link;

        Node(int n){
            this.data = n;
            this.link = null;
        }
    }
    Node first = null;
    
    void addFirst(int x){
        Node n = new Node(x);
        if(first == null){
            first = n;
        }
        else{
            n.link = first;
            first = n;
        }
    }

    void addLast(int x){
        Node n = new Node(x);
        Node temp = first;

        if(first == null){
            first = n;
        }
        else{
            while(temp.link != null){
                temp = temp.link;
            }
            temp.link = n;
        }
    }

    void deleteFirst(){
        if(first == null){
            System.out.println("Linked List is empty!");
        }
        else{
            System.out.println("Deleted element is: "+first.data);
            first = first.link;
        }
    }

    void deleteLast(){
        Node temp = first;
        if(first == null){
            System.out.println("Lined List is empty!");
        }
        else if(first.link == null){
            System.out.println("deleted element is: "+first.data);
            first = null;
        }
        else{
            while(temp.link.link != null){
                temp = temp.link;
            }
            System.out.println("Deleted element is: "+temp.link.data);
            temp.link = null;        
        }
    }

    void display(){
        Node temp = first;
        while(temp != null){
            temp = temp.link;
            System.out.print(temp.data + "-->");
        }
        System.out.println("null");
    }

    void deleteAtParticularValue(int x){
        Node temp = first;
        if(first == null){
            System.out.println("linked list is empty!");
        }
        else{
            if(first.data == x){
                first = first.link;
            }
            else{
                while(temp != null && temp.link.data != x){
                    temp = temp.link;
                }
            }
            if(temp.link != null){
                temp.link = temp.link.link;
            }
            else{
                System.out.println("Not Found!");
            }
        }
    }

    void addBeforeValue(int x, int value){
        Node n = new Node(x);
        Node temp;
        if(first == null){
            System.out.println("Linked List is empty!");
        }
        else{
            if(first.data == value){
                n.link = first;
                first = n;
            }
            else{
                temp = first;
                while(temp != null && temp.link.data != x){
                    temp = temp.link;
                }
                if(temp.link != null){
                    n.link = temp.link;
                    temp.link = n;
                }
                else{
                    System.out.println("Not found!");
                }
            }
        }
    }

    void insertAfterValue(int data,int value)
    {
        int flag = 0;
        if(first==null)
        {
            System.out.println("Linked is empty");
        }
        else
        {
            Node temp = first;
            while(temp != null)
           {
                if(temp.data == value)
                {
                    flag = 1;
                }
                temp = temp.link;
            }  
            if(flag == 0)
            {
                System.out.println("The asked value is not inside the linked list");
            }
            else
            {
                Node n = new Node(data);
                if(first.data == value && first.link== null)
                {
                    first.link=n;
                }
                else if(first.data == value)
                {
                    n.link=first.link;
                    first.link=n;
                }
                else
                {
                    temp=first;
                    while(temp.data!=value)
                    {
                        temp=temp.link;
                    }
                    n.link=temp.link;  
                    temp.link=n;
                }
            }
        }
    }
}

// class DECQ{
//     int Q[], f, r, n;

//     DECQ(int n){
//         this.n = n;
//         Q = new int[n];
//     }

//     void insertATrear(int x){
//         if(r == (f-n) % n){
//             System.out.println("Queue is full");
//         }
//         else{
//             if(r == n-1){
//                 r = 0;
//             }
//             else{
//                 r = r + 1;
//             }
//             Q[r] = x;
//             if(f == -1){
//                 f = 0;
//             }
//         }
//     }

//     void deleteATfront(){
//         if(f == -1){
//             System.out.println("Queue Underflow!");
//         }
//         int y = Q[f];
//         if(f == r){
//             f = r = -1;
//         }
//         else if(f == (n-1)){
//             f = 0;
//         }
//         else{
//             f++;
//         }
//         System.out.println();
//         System.out.println("Deleted Element is: "+y); 
//         System.out.println();
//     }

//     void insertATfront(int x){
//         if(f == (r+1) % n){
//             System.out.println("Queue is full!");
//         }
//         else{
//             if(f == -1){
//                 f = r = 0;
//             }
//             else if(f == 0){
//                 f = n-1;
//             }
//             else{
//                 f--;
//             }
//             Q[f] = x;
//         }
//     }

//     void deleteATrear(){
//         if(r == -1){
//             System.out.println("Queue Underflow!");
//         }
//         else{
//             int y = Q[r];
//             if(f == r){
//                 f = r = -1;
//             }
//             else if(r == 0){
//                 r = n-1;
//             }
//             else{
//                 r--;
//             }
//             System.out.println(y);
//         }
//     }
// }