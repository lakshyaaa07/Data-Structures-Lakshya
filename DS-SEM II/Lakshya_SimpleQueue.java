/* LAKSHYA JAIN
 * Algorithms for Simple Queue
 * 
 * 1. ~~ Insertion in simple queue ~~
 * 
 *    => Procedure enqueue(Q, F, R, N, X)
 *      1. Check Overflow?
 *         if(R >= N)
 *           then write "Queue Overflow!"
 *           Return
 * 
 *      2. Increament Rear pointer 
 *         R <-- R + 1
 * 
 *      3. Insert element
 *         Q[R] <-- X
 * 
 *      4. Set Front pointer
 *         if(F = 0)
 *           then F <-- 1
 * 
 * 2. ~~ Deletion in Simple Queue ~~
 *  
 *    => Function dequeue(Q, F, R)
 *      1. Check Underflow?
 *         if(F = 0)
 *           then write "Queue Undeflow!"
 *           Return 0 
 * 
 *      2. Delete Element
 *         y <-- Q[F]
 * 
 *      3. Is Queue Empty?
 *         if(F = R)
 *           then F <-- R <-- 0
 *         else
 *            F <-- F + 1
 * 
 *      4. Return Deleted Element
 *         Return(y)   
 */
import java.util.*;
public class Lakshya_SimpleQueue{
    int n;
    int Q[];
    int F = -1;
    int R = -1;

    Lakshya_SimpleQueue(int n){
        this.n = n;
        Q = new int[n];
    }

    //add element
    void enqueue(int x){
        //Check Overflow!
        if(R >= (n-1)){
            System.out.println("Queue Overflow!");
        }
        else{
            //increament of Rear pointer
            R++;
            //insering element
            Q[R] = x;
            //setting front pointer
            if(F == -1){
                F = 0;
            }
        }
    }

    //remove element 
    void dequeue(){
        //check Underflow
        if(F == -1){
            System.out.println("Queue Underflow!");
        }
        else{
            //delete element
            int y = Q[F];
            //Check is queue empty?
            if(F == R){
                F = R = -1;
            }
            else{
                F = F + 1;
            }
            //returing deleted element
            System.out.println("Deleted Element " + y);
        }
    }

    //Queue display method
    void display(){
        if(F == -1){
            System.out.println("Stack is empty!");
        }
        else{
            for(int i = F; i <= R; i++)
            System.out.println(Q[i] + " ");
        }   
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of Queue: ");
        int x = sc.nextInt();

        Lakshya_SimpleQueue q = new Lakshya_SimpleQueue(x);
        int ch;

        do{
            System.out.println("1. Insertion");
            System.out.println("2. Deletion");
            System.out.println("3. Display Queue");
            System.out.println("4. Exit");
            System.out.println();
            System.out.print("Enter choice: ");
            ch = sc.nextInt();

            switch(ch){

                case 1: System.out.print("Enter the element to insert: ");
                    int s = sc.nextInt();
                    q.enqueue(s);
                    break;

                case 2: System.out.println("Deletion of element....");
                    q.dequeue();
                    break;

                case 3: System.out.println("Displaying Queue.....");
                    q.display();
                    break;

                case 4: System.out.println("Exiting....");
                System.exit(0);
                break;
            }
        }while(ch != 4);
    }
}