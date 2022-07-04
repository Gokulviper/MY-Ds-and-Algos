package HEAP.MaxHeap;

import java.util.*;
class pair{
    String word;
    int freq;
    pair(String word,int freq){
        this.word=word;
        this.freq=freq;
    }
}
class MaxPqString{
    pair heap[];//store the max heap
    int n; //this n holdes as index maintainer and the size giver
    MaxPqString(int size){
        heap=new pair[size+1];
        n=0;
    }
    public int size(){
        return n;
    }
    public boolean isEmpty(){
        return n==0;
    }
    public void insert(String key,int value){
        if (n==heap.length-1){
            resizeHeap(2*heap.length);
        }
        n++;
        heap[n]=new pair(key,value);

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
        pair t=heap[a];
        heap[a]=heap[b];
        heap[b]=t;
    }

    private void resizeHeap(int size) {
        pair []temp=new pair[size];
        for (int i = 0; i <heap.length ; i++) {
            temp[i]=heap[i];
        }
        heap=temp;
    }
    public pair poll(){
        pair max=heap[1];
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
class TopKFrequntWords {
    public static void main(String[] args) {
       String[] words = {"i","love","leetcode","i","love","coding"};
       int  k = 2;
        System.out.println(topKFrequent(words,k));
    }
    static public List<String> topKFrequent(String[] words, int k) {
        MaxPqString pq=new MaxPqString(words.length+1);
        HashMap<String,Integer>map=new HashMap<>();
        for (String s:words){
            map.put(s,map.getOrDefault(s,0)+1);
        }
        List<String> ans=new ArrayList<>();
        for (String s:map.keySet()){
            pq.insert(s,map.get(s));
        }
        while (!pq.isEmpty()&&k-->0){
            ans.add(pq.poll().word);

        }
        for(int i=0; i<ans.size()/2; i++)
            Collections.swap(ans, i, ans.size()-i-1);
        return ans;
    }
}