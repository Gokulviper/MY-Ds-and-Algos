package HEAP.MaxHeap;


import java.util.Arrays;

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
    public void insert(int value){
        if (n==heap.length-1){
            resizeHeap(2*heap.length);
        }
        n++;
        heap[n]=value;
        swim(n);
    }

    private void swim(int n) {
        //n/2 is check the parent is in the correct position or not
        while (n>1&&heap[n/2]<heap[n]){
            Swap(n/2,n);
            n/=2;
        }
    }

    private void Swap(int a, int b) {
        int t=heap[a];
        heap[a]=heap[b];
        heap[b]=t;
    }

    private void resizeHeap(int size) {
        int []temp=new int[size];
        for (int i = 0; i <heap.length ; i++) {
            temp[i]=heap[i];
        }
        heap=temp;
    }

    public static void main(String[] args) {
        MaxPq pq=new MaxPq(10);
     pq.insert(2);
        pq.insert(5);
        pq.insert(8);
        pq.insert(3);
        pq.insert(9);
        pq.insert(21);
        pq.insert(1);
        System.out.println(pq.size());
        System.out.println(Arrays.toString(pq.heap));
    }

}
