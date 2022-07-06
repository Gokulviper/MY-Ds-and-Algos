package Trie;
class Node {
    Node links[] = new Node[26];
    boolean flag = false;

    public Node() {

    }
    boolean isNull(int num){
        return links[num]==null;
    }

    boolean containsKey(char ch) {
        return (links[ch - 'a'] != null);
    }
    Node get(char ch) {
        return links[ch-'a'];
    }
    void put(char ch, Node node) {
        links[ch-'a'] = node;
    }
    void setEnd() {
        flag = true;
    }
    boolean isEnd() {
        return flag;
    }
}
public class TriePrefixTree1 {
     static Node root;
    //Initialize your data structure here
    TriePrefixTree1() {
        root = new Node(); 
    }
    //Inserts a word into the trie
    public static void insert(String word) {
        Node node = root;
        for(int i=0;i<word.length();i++) {
            if(!node.containsKey(word.charAt(i))) { //the node is already present simply add the
                node.put(word.charAt(i), new Node()); //every time create new reference node with marking
            }
            node = node.get(word.charAt(i)); //go to the next marked node
        }
        node.setEnd(); //at the end make true
    }


    //Returns if the word is in the trie

    public static boolean search(String word) {
        Node node = root; 
        for(int i = 0;i<word.length();i++) {
            if(!node.containsKey(word.charAt(i))) { //if any charcter not match with word return false
                return false; 
            }
            node = node.get(word.charAt(i)); 
        }
       return node.isEnd(); //in at the end check the fully word or not
    }

    
    //Returns if there is any word in the trie that starts with the given prefix

    public static boolean startsWith(String prefix) {
        Node node = root; 
        for(int i = 0;i<prefix.length();i++) {
            if(!node.containsKey(prefix.charAt(i))) { //this function you dont need to check the end
                return false; 
            }
            node = node.get(prefix.charAt(i)); 
        }
        return true; 
    }
    public static void main(String args[])
{
	int n = 5;
	int type[] = {1, 1, 2, 3, 2};
	String value[] = {"hello", "help", "help", "hel", "hel"};
	TriePrefixTree1 trie=new TriePrefixTree1();
	insert("hello");
    insert("help");
	for (int i = 0; i < n; i++) {
		if (type[i] == 1) {
			trie.insert(value[i]);
		}
		else if (type[i] == 2) {
			if (trie.search(value[i])) {
				System.out.println( "true" );
			}
			else {
				System.out.println("false");
			}
		}
		else {
			if (trie.startsWith(value[i])) {
				System.out.println("true" );
			}
			else {
				System.out.println("false");
			}
		}
	}
}
}