package Graph.Problems;

import java.util.*;

class Node {
    public int val;
    public List<Node> adj;
    public Node() {
        val = 0;
        adj = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        adj = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        adj = _neighbors;

    }
}
class CloneGraph {
    public Node dfs(Node node) {
        if(node==null) return null;
        Map<Integer,Node> visited = new HashMap<>();
        return dfs(node, visited);
    }
    
    private Node dfs(Node u, Map<Integer,Node> visited) {
        Node NewNode = new Node(u.val, new ArrayList<>());
        visited.put(u.val, NewNode);
        for(Node v: u.adj) {
            if (visited.containsKey(v.val))
                NewNode.adj.add(visited.get(v.val));
            else
                NewNode.adj.add(dfs(v, visited));
        }
        return NewNode;
    }
}