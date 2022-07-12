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
    public int get(Integer key){
        if (key==null) throw new IllegalArgumentException("key is null");
        int index=getBucketIndex(key);
        HashNode head=buckets[index] ;
      while (head!=null){
          if (head.key==key){
              return head.value;
          }
          head=head.next;
      }
      return -1;
    }
    public int remove(Integer key){
        if (key==null)throw new IllegalArgumentException("key not valid");
        int index=getBucketIndex(key);
        HashNode previous=null;
        HashNode head=buckets[index];
        while (head!=null){
            if (head.key==key){
                break;
            }
            if (head==null){
                return -222;
            }
            previous=head;
            head=head.next;
        }
        size--;
        if (previous!=null){
            previous.next=head.next;
        }else{
            buckets[index]=head.next;
        }
        return head.value;
    }

    private int getBucketIndex(Integer key) {
        return key%numOfBuckets;

    }

    public static void main(String[] args) {
        HashTable hs=new HashTable();
        hs.put(3,3);
        hs.put(6,6);
        hs.put(16,16);
        hs.put(9,9);
        System.out.println(hs.get(16));
    }
}
