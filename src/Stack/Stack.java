package Stack;

import java.util.EmptyStackException;

public class Stack {
    Node top;
    static int size;
   static class Node{
       int data;
       Node next;

       Node(int data){
           this.data=data;
           this.next=null;

       }
   }
   Stack(){
       top=null;
       size=0;
   }
   Stack(int size){
       top=null;
       size=size;
   }
   public void push(int data){
       Node node=new Node(data);
     node.next=top;
     top=node;
     size++;
   }
   public int pop(){
       if (Stack.isEmpty()){
          throw new EmptyStackException();
       }
       int temp=top.data;
       top=top.next;
       return temp;

   }
   public int peek(){
       if (Stack.isEmpty()){
           throw new EmptyStackException();
       }
       return top.data;
   }

    private static boolean isEmpty() {
       return size==0;
    }

    private int size() {
       return size;
    }

    public static void main(String[] args) {
        Stack stack=new Stack();
        stack.push(5);
        stack.push(6);
        stack.push(8);
        stack.push(1);
        stack.push(9);
        stack.push(9);
        stack.push(9);
        System.out.println(stack.size());;





    }

}
