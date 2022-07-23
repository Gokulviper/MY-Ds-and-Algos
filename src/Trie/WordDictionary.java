package Trie;

class WordDictionary {
  Node root;
    public WordDictionary() {
        root=new Node();
    }
    
    public void addWord(String word) {
        Node node=root;
        for (int i = 0; i < word.length(); i++) {
            if (!node.containsKey(word.charAt(i))){
                node.put(word.charAt(i),new Node());
            }
            node=node.get(word.charAt(i));
        }
        node.setEnd();
    }
    
    public boolean search(String word) {
        boolean res=false;
        if (root==null){
            return false;
        }
        Node node = root;
        for(int i = 0;i<word.length();i++) {
            if (word.charAt(i) == '.') {
                for (int j = 0; j < 26; j++) {
                    if (!node.isNull(j)){
                        node=node.links[j];
                        continue;
                    }
                }
                return false;
            } else {
                if(!node.containsKey(word.charAt(i))){ //if any charcter not match with word return false
                    return false;
                }
                node = node.get(word.charAt(i));
            }
        }
        return node.isEnd(); //in at the end check
     //   return res;
    }



    public static void main(String[] args) {
        WordDictionary w=new WordDictionary();
        w.addWord("bad");
        w.addWord("dad");
        w.addWord("mad");
        System.out.println(w.search("pad"));
        System.out.println(w.search("bad"));
        System.out.println(w.search(".ad"));
        System.out.println(w.search("b.."));

    }
}
