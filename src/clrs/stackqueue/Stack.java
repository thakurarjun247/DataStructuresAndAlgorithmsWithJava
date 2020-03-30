package clrs.stackqueue;

import java.util.NoSuchElementException;
class App{
    public static void main(String[] args) {
        Stack s=new Stack();
        System.out.println(s.isEmpty());
        System.out.println(s.pop());
        s.push(0);
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
    }
}
public class Stack {
    int size = 4;
    int top = -1;
    int[] a = new int[size];

    boolean isEmpty() {
        return top == (-1);
    }
    int pop(){
        if(isEmpty()) {
            System.out.println("underflow");
            return Integer.MIN_VALUE;
        }
        else
        {
            int key=a[top];
            top--;
            return key;
        }

    }
    void push(int key){
        if(top==(size-1))
            System.out.println("overflow");
        else
            a[++top]=key;
    }
}
