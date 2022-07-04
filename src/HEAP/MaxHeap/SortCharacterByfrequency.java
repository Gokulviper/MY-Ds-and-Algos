package HEAP.MaxHeap;

import java.util.HashMap;

class Node1{
    char ch;
    int freq;
    Node1(char ch,int freq){
       this.ch=ch;
       this.freq=freq;
    }
}
class MaxPqChars{
    Node1 heap[];//store the max heap
    int n; //this n holdes as index maintainer and the size giver
    MaxPqChars(int size){
        heap=new Node1[size+1];
        n=0;
    }
    public int size(){
        return n;
    }
    public boolean isEmpty(){
        return n==0;
    }
    public void insert(char key,int value){
        if (n==heap.length-1){
            resizeHeap(2*heap.length);
        }
        n++;
        heap[n]=new Node1(key,value);

        swim(n);
    }

    private void swim(int n) {
        //n/2 is check the parent is in the correct position or not
        while (n>1&&heap[n/2].freq<heap[n].freq){
            Swap(n/2,n);
            n/=2;
        }
    }

    private void Swap(int  a, int b) {
        Node1 t=heap[a];
        heap[a]=heap[b];
        heap[b]=t;
    }

    private void resizeHeap(int size) {
        Node1 []temp=new Node1[size];
        for (int i = 0; i <heap.length ; i++) {
            temp[i]=heap[i];
        }
        heap=temp;
    }
    public Node1 poll(){
        Node1 max=heap[1];
        Swap(1,n);
        n--;

        sink(1);  heap[n+1]=null;
        // if (n>1&&(n==(heap.length-1)/4)) {
        ///         resizeHeap(heap.length/2);
        //    }
        return max;
    }

    private void sink(int k) {
        while (2*k<=n){
            int j=2*k;
            if (j<n&&heap[j].freq<heap[j+1].freq){
                j++;
            }

            if (  heap[k].freq >=heap[j].freq){
                break;
            }
            Swap(j,k);
            k=j;
        }
    }
}
class SortCharacterByfrequency {
    public static void main(String[] args) {
       String s = "tree";
        System.out.println(frequencySort(s));
    }
    public static String frequencySort(String s) {
        MaxPqChars pq=new MaxPqChars(s.length()+1);
        HashMap<Character,Integer>map=new HashMap<>();

        for (char ch:s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        for (char ch: map.keySet()){
            pq.insert(ch,map.get(ch));
        }
        StringBuilder sb=new StringBuilder();
       while (!pq.isEmpty()){
           Node1 node=pq.poll();
           int n= node.freq;
           while (n-->0){
               sb.append(node.ch);
           }
       }
       return sb.toString();
    }
}