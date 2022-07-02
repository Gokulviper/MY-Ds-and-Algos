package HEAP.MaxHeap;

public class MaxPq {
    int heap[];//store the max heap
    int n; //this n holdes as index maintainer and the size giver
    MaxPq(int size){
        heap=new int[size+1];
        n=0;
    }
    public int size(){
        return n;
    }
    public boolean isEmpty(){
        return n==0;
    }

}
