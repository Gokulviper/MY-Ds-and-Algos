package Stack.Design;

public class DesignStackGetMinConstantTime {
    Node top;
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    DesignStackGetMinConstantTime(){
        top=null;
    }
    public void push(int data){
        Node node=new Node(data);
        if (top==null){
            top=node;
            return;
        }
        Node current=top;
        while (node.data>current.data&&current!=null){
            if (node.data<current.data){
                swapp(node,current);
            }
            current=current.next;
        }

    }

    private void swapp(Node node, Node current) {
        Node temp=current;
        node.next=current.next;
        temp.next=node;

    }

  //  public int pop(){

  //  }
  //  public int top(){
  //
  //  }
  //  public int getMin(){

  //  }

}
