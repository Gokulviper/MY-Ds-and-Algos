package HashIng.Design;

class MyHashSet {
    int numberOfBuckets;
    HashNode[]buckets;
    public MyHashSet() {
     buckets=new HashNode[10];

    }
    class HashNode{
        int key;
        HashNode next;
        HashNode(int key){
            this.key=key;
            next=null;
        }
    }
    public void add(int key) {
        int index=getBucketIndex(key);
        HashNode head=buckets[index];
        while (head!=null){
            if (head.key==key){
                return;
            }
            head=head.next;
        }
        head=buckets[index];
        HashNode node=new HashNode(key);
        node.next=head;
        buckets[index]=node;
    }

    private int getBucketIndex(int key) {
        return key%buckets.length;
    }

    public void remove(int key) {
        int index=getBucketIndex(key);
        HashNode head=buckets[index],prev=null;
        while (head!=null){
            if (head.key== key){
                break;
            }

            prev=head;
            head=head.next;
            if (head==null)return;
        }
        if (prev!=null)
        prev.next=head.next;
        else {
            if (head!=null)
            buckets[index]=head.next;
        }


    }
    
    public boolean contains(int key) {
        int index=getBucketIndex(key);
        HashNode head=buckets[index];
        while (head!=null){
            if (head.key==key){
                return true;
            }
            head=head.next;
        }
        return false;
    }
}