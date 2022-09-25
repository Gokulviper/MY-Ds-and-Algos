package Design;

import java.util.Stack;

class MinStack {

   Stack<Integer> stack=new Stack();
    Stack<Integer> min_values=new Stack();
    public void push(int val) {
        if(min_values.isEmpty()||min_values.peek()>=val){
            min_values.push(val);
        }
        stack.push(val);
    }
    
    public void pop() {
        if(stack.peek().equals(min_values.peek())){
            min_values.pop();
        }
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min_values.peek();
    }
}