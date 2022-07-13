package HashIng.Design;

class LRUCache {
    Node[]buckets;
    int numOfBuckets;
    int size;
    int len;
    class Node{
        int key;
        int value;
        Node next;
        Node(int key,int value){
            this.key=key;
            this.value=value;

        }
    }

   static   int[] lru=new int[1000];
    static int i=0;
    public LRUCache(int capacity) {
        buckets=new Node[capacity];
        numOfBuckets =capacity;
        size=0;
        len=capacity;
    }
    private int actualSize(){
        return len;
    }
    
    public int get(int key) {
       // lru=key;
        int index=getBucketIndex(key);
        Node head=buckets[index];
        while (head!=null){
            if (head.key==key){
                return head.value;
            }
            head=head.next;
        }
        return -1;
    }
    
    public void put(int key, int value) {
       if (size==actualSize()){
           remove(lru[--i]);
       }
        int index=getBucketIndex(key);
        Node head=buckets[index];

        while (head!=null){
            if (head.key==key){
                head.value=value;
            }
            head=head.next;
        }
        size++;
        head=buckets[index];
        Node node=new Node(key,value);
        node.next=head;
        buckets[index]=node;
        lru[i++]=key;
    }

    private void remove(int key) {
        int index=getBucketIndex(key);
        Node head=buckets[index];
         Node prev=null;
         while (head!=null){
             if (head.key==key){
                 break;
             }
             prev=head;
             head=head.next;
             if (head==null)return;
         }
         if (prev!=null){
             prev.next=head.next;
         }else{
             if (head!=null){
                 buckets[index]=head.next;
             }
         }
         size--;
         lru[i]=0;
         i--;
    }

    private int getBucketIndex(int key) {
        return key%numOfBuckets;
    }

    public static void main(String[] args) {
        LRUCache l=new LRUCache(2);
        l.put(1,1); l.put(2,2);
        System.out.println(l.get(1));
        l.put(3,3);
        System.out.println(l.get(2));
        l.put(4,4);
        System.out.println(l.get(1));
        System.out.println(l.get(3));
        System.out.println(l.get(4));
    }
}