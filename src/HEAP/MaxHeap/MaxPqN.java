package HEAP.MaxHeap;
class Node{
    int key;
    int value;
    Node(int key,int value){
        this.key=key;
        this.value=value;
    }

}
public class MaxPqN {
    Node heap[];//store the max heap
    int n; //this n holdes as index maintainer and the size giver
    MaxPqN(int size){
        heap=new Node[size+1];
        n=0;
    }
    public int size(){
        return n;
    }
    public boolean isEmpty(){
        return n==0;
    }
    public void insert(int key,int value){
        if (n==heap.length-1){
            resizeHeap(2*heap.length);
        }
        n++;
        heap[n]=new Node(key,value);

        swim(n);
    }

    private void swim(int n) {
        //n/2 is check the parent is in the correct position or not
        while (n>1&&heap[n/2].value<heap[n].value){
            Swap(n/2,n);
            n/=2;
        }
    }

    private void Swap(int a, int b) {
        Node t=heap[a];
        heap[a]=heap[b];
        heap[b]=t;
    }

    private void resizeHeap(int size) {
        Node []temp=new Node[size];
        for (int i = 0; i <heap.length ; i++) {
            temp[i]=heap[i];
        }
        heap=temp;
    }
    public int poll(){
        Node max=heap[1];
        Swap(1,n);
        n--;

        sink(1);  heap[n+1]=null;
        // if (n>1&&(n==(heap.length-1)/4)) {
        ///         resizeHeap(heap.length/2);
        //    }
        return max.key;
    }

    private void sink(int k) {
        while (2*k<=n){
            int j=2*k;
            if (j<n&&heap[j].value<heap[j+1].value){
                j++;
            }

            if (  heap[k].value >=heap[j].value){
                break;
            }
            Swap(j,k);
            k=j;
        }
    }

    public static void main(String[] args) {
        MaxPqN pq=new MaxPqN(6);
        pq.insert(3,5);
        pq.insert(1,2);
        pq.insert(6,9);
        System.out.println(pq.poll());
    }

}
