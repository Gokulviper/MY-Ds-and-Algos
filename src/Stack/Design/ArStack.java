package Stack.Design;

import javax.crypto.ExemptionMechanismException;
import java.util.Arrays;
import java.util.EmptyStackException;

public class ArStack {
    int[]nums;
    int top;
  static   int size;
    ArStack(int len){
        nums=new int[len];
        size=0;
    }
    ArStack(){
        nums=new int[10];
        size=0;
    }
    public void push(int value){
        if (nums.length-1<size){
            resize(nums.length*2);
        }
        if (size==0){
            top=value;
            nums[size]=value;
            size++;
        }else
        {
            nums[size]=value;
            top=value;
            size++;
        }
    }
    public int pop(){
        if (ArStack.isEmpty()){
            throw  new EmptyStackException();
        }
       size--;
        int ans= top;
        top=nums[size];
        return ans;

    }
    public int peek(){
        if (ArStack.isEmpty()){
            throw  new EmptyStackException();
        }
        return top;
    }

    private static boolean isEmpty() {
        return size==0;
    }

    private void resize(int capacity) {
        int[]temp=new int[capacity];
        for(int i=0;i< nums.length;i++){
            temp[i]=nums[i];
        }
        nums=temp;
    }
    public int getMin(){
        if (ArStack.isEmpty()){
            throw new EmptyStackException();
        }
        int[]temp=nums.clone();
        Arrays.sort(temp);
        return temp[0];

    }

    public static void main(String[] args) {
        ArStack stack=new ArStack();
        stack.push(3);
        stack.push(5);
        stack.push(7);
        stack.push(9);stack.push(12);
        System.out.println(stack.getMin());
}}
