package HashIng.Design;

class MyHashMap {
   HashNode[]bucket;
   int numBucketIndex;
    public MyHashMap() {
        bucket=new HashNode[10];
        this.numBucketIndex=10;
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
    
    public void put(int key, int value) {
         int index=getBucketIndex(key);
        HashNode head=bucket[index];
        while (head!=null){
            if (head.key==key){
                head.value=value;
                return;
            }
            head=head.next;
        }
        HashNode node=new HashNode(key,value);
        head=bucket[index];
        node.next=head;
        bucket[index]=node;
        
    }
     private int getBucketIndex(int key) {
        return key%numBucketIndex;
    }
    
    public int get(int key) {
         int index=getBucketIndex(key);
        HashNode head=bucket[index];
        while (head!=null){
            if (head.key==key){
                return head.value;
            }
            head=head.next;
        }
        return -1;
    }
    
    public void remove(int key) {
         int index=getBucketIndex(key);
        HashNode head=bucket[index],prev=null;
        while (head!=null){
            if (head.key==key)break;
           prev=head;
            head=head.next;
            if (head==null)return;
        }
        if (prev!=null){
            prev.next=head.next;
        }else{
            if(head!=null)
            bucket[index]=head.next;
        }
    }
}



