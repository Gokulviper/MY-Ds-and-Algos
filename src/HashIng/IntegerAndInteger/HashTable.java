package HashIng.IntegerAndInteger;

public class HashTable {
    HashNode[]buckets;
    int numOfBuckets;
    int size;
    HashTable(){
     this(10);

    }
    HashTable(int size){
        numOfBuckets=size;
        this.size=0;
        buckets=new HashNode[numOfBuckets];

    }
    class HashNode{
        int key;
        int value;
        HashNode next;
        HashNode(int key,int value){
            this.key=key;
            this.value=value;
        }
    }
    public boolean isEmpty(){
       return size==0;
    }
    public void put(Integer key,Integer value){
        if(key==null||value==null)return;
        int index=getBucketIndex(key);
        HashNode head=buckets[index];
        while (head!=null){
            if (head.key==key){
                head.value=value;
                return;
            }
            head=head.next;
        }
        size++;
        head=buckets[index];
        HashNode node=new HashNode(key,value);
        node.next=head;
      buckets[index]=node;
    }

    private int getBucketIndex(Integer key) {
        return key%numOfBuckets;
    }
}
