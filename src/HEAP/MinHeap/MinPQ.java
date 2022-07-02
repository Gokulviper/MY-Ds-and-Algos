package HEAP.MinHeap;

public class MinPQ {
    int n;
    int[]heap;
    MinPQ(int size){
        heap=new int[size+1];
        n=0;
    }
    int size(){
        return n;
    }
    boolean isEmpty(){
        return n==0;
    }
    int poll(){
        int min=heap[1];
        swap(1,n);
        n--;
        heap[n+1]=0;
        if (n>0&&(n==(heap.length-1)/4)){
            resize(heap.length/2);
        }
        sink(1);
        return min;
    }

    private void sink(int k) {
        while (2*k<=n){
            int j=2*k;
            if (j>0&&heap[j]>heap[j+1]){
                j++;
            }
            if (heap[k]<=heap[j]){
                break;
            }
            swap(k,j);
            k=j;
        }
    }

    void add(int value){
        if (n==heap.length-1){
            resize(2*heap.length);
        }
        n++;
        heap[n]=value;
        swim(n);
    }

    private void swim(int k) {
        while (k>0&&heap[k]<heap[k/2]){
            swap(k,k/2);
            k/=2;
        }
    }
    void swap(int a,int b){
        int t=heap[a];
        heap[a]=heap[b];
        heap[b]=t;
    }

    private void resize(int size) {
        int[]temp=new int[size];
        for (int i = 0; i < heap.length ; i++) {
            temp[i]= heap[i];
        }
        heap=temp;
    }

    public static void main(String[] args) {

    }
}
