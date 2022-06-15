package Graph.GraphTheories.Problems;

import java.util.*;

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;

    }
}
class Solution {
    public Node cloneGraph(Node node) {
        if(node==null) return null;
        Map<Integer,Node> visited = new HashMap<>();
        return cloneGraph(node, visited);
    }
    
    private Node cloneGraph(Node node, Map<Integer,Node> visited) {
        Node clonedNode = new Node(node.val, new ArrayList<>());
        visited.put(node.val, clonedNode);
        for(Node neighbor: node.neighbors) {
            if (visited.containsKey(neighbor.val)) clonedNode.neighbors.add(visited.get(neighbor.val));
            else clonedNode.neighbors.add(cloneGraph(neighbor, visited));
        }
        return clonedNode;
    }
}