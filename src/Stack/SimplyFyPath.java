package Stack;

import java.util.Stack;

class SimplyFyPath {
    //cases we noted
    //first case : // split is // so the string is empty we not consider it
    //2 case : ..previous directory simply pop the current diretory using stack
    //3 case: . we do nothing simply take on and dont add the answer
    //4 otherwise only directory names pushed in the stack
    public String simplifyPath(String path) {
         String[]s=path.split("/");
        Stack<String> stack=new Stack<>();
        for(String ss:s){
            if(!ss.isEmpty()){
                if(ss.equals("..")){
                    if(!stack.isEmpty())
                    stack.pop();
                }else if(ss.equals(".")){
                      continue;
                }else{
                    stack.push(ss);
                }
            }
        }
        StringBuilder ans= new StringBuilder();
        while(!stack.isEmpty()){
            if(stack.size()==1){
                ans.insert(0, stack.pop());
            }else{
                ans.insert(0, "/" + stack.pop());
            }
        }
        return "/"+ans;
    }
}