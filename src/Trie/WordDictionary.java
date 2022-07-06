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
     return dfs(word,0,root);
    }

    private boolean dfs(String word, int i, Node node) {
        boolean res=false;
        if (root==null){
            return false;
        }
        if (i==word.length()&& root.isEnd()){
            return true;
        }
        if (i==word.length()){
            return res;
        }
        if (word.charAt(i)=='.'){
            for (int j = 0; j <26 ; j++) {
                if (!node.isNull(j)){
                res=res||dfs(word,i+1,node.links[j]);


                }
            }
        }else{
            int index=word.charAt(i)-'a';
            res=res||dfs(word, i+1, node.links[index]);
        }
        return res;
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
