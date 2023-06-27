// ALGO
/*
 * Base Case: 
 *      if(n == 1)
 *          then move ring from A to C.
 * 
 * Recursive Case:
 *      I.   Move (n-1) ring from A to B using C as intermediate poll
 *      II.  Move one left ring from A to C using B as intermediate poll
 *      III. Move (n-1) left ring from B to C using A as intermediate poll
 */

// CODE
import java.util.*;
class toh{
    static int steps = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no of rings: ");
        int n = sc.nextInt();

        int A = 1;
        int B = 2;
        int C = 3;
        
        TOH(n,A,B,C); 
    }
    static void TOH(int n, int A, int B, int C){
        steps++;
        if(n==1){
            System.out.println("Move " + n + " Rings from " + A + " to " + C);
        }
        else{
            TOH(n-1, A, C, B);
            System.out.println("Move "+n+" Rings from "+A+" to "+C);
            TOH(n-1,B,A,C);
        }
    }
}