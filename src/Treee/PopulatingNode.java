package Treee;

public class PopulatingNode {
}
//This solution works for both 116. Populating Next Right Pointers in Each Node and 117. Populating Next Right Pointers in Each Node II
  /*
//algorithm
//level order traversal
//every level start declare inside null
//poll every element and point to next



  public Node connect(Node root) {
        Queue<Node> q = new LinkedList<>();
        if(root != null)
            q.add(root);
        while(!q.isEmpty()) {
            int size = q.size();
            Node next = null;
            for(int i = 0; i < size; i++) {
                Node node = q.poll();
                node.next = next;
                next = node;
                if(node.right != null) q.add(node.right);
                if(node.left != null) q.add(node.left);
            }
        }
        return root;
    }
}




  if(root==null||root.left==null||root.right==null)return root;
     //we can easily connect the same side of tree
        root.left.next=root.right;
        //this case for opposite side tree
        //idea
        //you are in left
        //already the left and right are connected in the previous action
        //connect cuurent.right->next.left
        if(root.next!=null){
            root.right.next=root.next.left;
        }
        connect(root.left);
        connect(root.right);
        return root;

    }






*/