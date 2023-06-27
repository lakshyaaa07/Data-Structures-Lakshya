import java.util.*;
class Stack{
    int top=-1;
    char s[];
    int n;

    Stack(int size){
        n = size;
        s = new char[n]; 
    }

    void push(char x){
        if(top >= (n-1)){
            System.out.println("Stack is Overflow!");
        }
        else{
            top++;
            s[top] = x;
        }
    }

    char pop(){
        if(top == -1){
            return '1';
        }
        else{
            top--;
            return s[top+1];
        }
    }
    String rev = "";
        void revString(String in){
            for(int i=0; i<in.length(); i++){
                char ch = in.charAt(i);
                push(ch);
            }
            while(top != -1){
                char ch = pop();
                rev = rev + ch;
            }
            System.out.println(rev);
        }
    }   

class rev_String{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter String: ");
        String data = sc.nextLine();
        Stack s1 = new Stack(data.length());

        s1.revString(data);
    }
}