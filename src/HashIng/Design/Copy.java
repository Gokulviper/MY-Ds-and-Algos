package HashIng.Design;

public class Copy {
    HashNode[]buckets;
    int numOfBuckets;
    Copy(){
        buckets=new HashNode[10];
        numOfBuckets=10;
    }
    class HashNode{
        int key,value;
        HashNode next;
        HashNode(int key,int value){
            this.key=key;
            this.value=value;
        }
    }

    public void put(int key,int value){
        int index=getBucketIndex(key);
        HashNode head=buckets[index];
    }

    private int getBucketIndex(int key) {
        return key%numOfBuckets;
    }
}
