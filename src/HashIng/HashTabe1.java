package HashIng;

public class HashTabe1 {
    Node[]buckets;
    int numOfBuckets;
    int size;
    HashTabe1(int capacity){
        this.numOfBuckets=capacity;
        buckets=new Node[capacity];
    }
    class Node{
        Integer key;
        String value;
        Node next;
        Node(Integer key,String value){
            this.key=key;
            this.value=value;
        }
    }

}
