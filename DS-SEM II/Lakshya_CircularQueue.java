/* LAKSHYA JAIN
 * Algorithms for Circular Queue!
 * 
 * 1. ~~ Insertion in Circular Queue ~~
 * 
 *    => Procedure CQ_INSERT(Q, F, R, N, X)
 *      1. Reset Rear Pointer
 *         if(R = N)
 *           then R <-- 1
 *         else
 *           R <-- R + 1
 * 
 *      2. Is queue Full?
 *         if(F = R)
 *           then write "Queue Overflow!"
 *           Exit
 * 
 *      3. Insert the element
 *         Q[R] <-- X
 * 
 *      4. Set Front pointer
 *         if (F = 0)
 *            then F <-- 1
 * 
 * 2. ~~ Deletion in Circular Queue ~~
 * 
 *    => Function CQ_DELETE(Q,F,R)
 *      1. Check Underflow?
 *         if(F = 0)
 *           then write "Queue Underflow!"
 *           Return 0
 * 
 *      2. Delete Element
 *         y <-- Q[F]
 * 
 *      3. Is queue empty?
 *         if(F = R)
 *           then F <-- R <-- 0
 *           Return y
 * 
 *      4. Reset front pointer
 *         if(F = N)
 *           then F <-- 1
 *         else
 *            F <-- F + 1
 * 
 *      5. Return deleted element
 *         Return y
 */
import java.util.*;
public class Lakshya_CircularQueue{
    int f = -1;
    int r = -1;
    int n;
    int Q[];

    Lakshya_CircularQueue(int n){
        this.n = n;
        Q = new int[n];
    }
    //add element in Q
    void Insert_CQ(int x){
        if(r == (f-1) || (f == (n-1) && (f == 0))){
            System.out.println("Queue is full");
        }
        else{
            if(r == (n-1)){
                r = 0;
            }
            else{
                r = r + 1;
            }
            Q[r] = x;
            if(f == -1){
                f = 0;
            }
        }
    }
    

    void Delete_CQ(){
        //Check Underflow!
        if(f == -1){
            System.out.println("Queue is Undeflow!");
            return;
        }
        //Delete element
        int y = Q[f];

        //Is queue empty?
        if(f == r){
            f = r = -1;
        }
        //Reset front pointer
        else if(f == (n-1)){
            f = 0;
        }
        else{
            f++;
        }
        //Return deleted element
        System.out.println("Deleted element is: "+y);
    }

    void display_CQ(){
        if(f == -1){
            System.out.println("Queue is empty!");
        }
        else{
            for(int i=f; i!=r; i=(i+1)%n){
                System.out.print(Q[i] + " ");
            }
            System.out.println(Q[r]);   
        }
    }
}

class Lakshya_Main_CQ{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of Queue: ");
        int x = sc.nextInt();

        Lakshya_CircularQueue q = new Lakshya_CircularQueue(x);
        int ch;

        do{
            System.out.println("1. Insertion of element");
            System.out.println("2. Deletion of element");
            System.out.println("3. Display Queue");
            System.out.println("4. Exit");
            System.out.println();
            System.out.print("Enter choice: ");
            ch = sc.nextInt();

            switch(ch){

                case 1: System.out.print("Enter the element to insert: ");
                    int s = sc.nextInt();
                    q.Insert_CQ(s);
                    q.display_CQ();
                    break;

                case 2: System.out.println("Deletion of element....");
                    q.Delete_CQ();
                    q.display_CQ();
                    break;

                case 3: System.out.println("Displaying Queue.....");
                    q.display_CQ();
                    break;

                case 4: System.out.println("Exiting....");
                System.exit(0);
                break;
            }
        }while(ch != 4);
    }
}