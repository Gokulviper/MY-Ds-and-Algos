package Trie;
class Node2{
    Node2 links[]=new Node2[26];
    boolean falg=false;
    public Node2(){
    }
    Node2 get(char ch){
        return links[ch-'a'];
    }
    boolean containsKey(char ch){
        return links[ch-'a']!=null;
    }
    void put(char ch,Node2 node){
        links[ch-'a']=node;
    }
    void setEnd(){
        falg=true;
    }
    boolean isEnd(){
        return falg;
    }
}
class Triee {
 static Node2 root;
    public Triee() {
       root=new Node2();
    }
    
    public void insert(String word) {
       Node2 node=root;
        for(int i=0;i<word.length();i++){
            if(!node.containsKey(word.charAt(i))){
               node.put(word.charAt(i),new Node2());
            }else{
                node=node.get(word.charAt(i));
            }
        }
        node.setEnd();
        
    }
    
    public boolean search(String word) {
       Node2 node=root;
        for (int i = 0; i <word.length() ; i++) {
            if(node.containsKey(word.charAt(i))){
                node=node.get(word.charAt(i));
            }else{
                return false;
            }
        }
        return node.isEnd();
        
    }

    public boolean startsWith(String word) {
       Node2 node=root;
        for (int i = 0; i <word.length(); i++) {
            if (node.containsKey(word.charAt(i))){
            node=node.get(word.charAt(i));
            }else {
                return false;
            }
        }
        return true;
    }
}

