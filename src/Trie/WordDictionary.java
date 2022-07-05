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
        Node node=root;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i)=='.')continue;
            if (!node.containsKey(word.charAt(i))&&word.charAt(i)!='.'){
                return false;
            }

            node=node.get(word.charAt(i));
        }
        return true;
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
