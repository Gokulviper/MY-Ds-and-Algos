package BFS;

import java.util.*;
/*

1. Use Queue and BFS to find answers .
2. First add the given string in queue .
3. each level we will remove 1 more char and will add all the possible string in queue
4. Once we found a valid string , we will only process that level and no more , as we know , that will be the minimum deletion required .
   Hence using isValidFound flag for that


*/
class RemoveInvalidParenthesis {
  public static void main(String[] args) {
    RemoveInvalidParenthesis r = new RemoveInvalidParenthesis();
    String s = "()())()";
    System.out.println(r.removeInvalidParentheses(s));

  }
  public List<String> removeInvalidParentheses(String s) {

    HashSet<String> set = new HashSet<>() ;     // To Avoid duplicate
    Queue<String> queue = new LinkedList<>();
    boolean isValidFound = false ;
    queue.add(s);

    List<String> result = new ArrayList<>();

    while(!queue.isEmpty() && !isValidFound){

      int size = queue.size() ;

      for(int i=0 ; i<size ; i++){

        String cur = queue.poll() ;
        if(isValid(cur)){
          isValidFound = true ;
          result.add(cur);
        }else if(!isValidFound){

          for(int j=0 ; j<cur.length() ; j++){

            if(Character.isLetter(cur.charAt(j))) continue ;

            String new_str = cur.substring(0,j) + cur.substring(j+1);

            if(!set.contains(new_str)){
              queue.add(new_str);
              set.add(new_str);
            }

          }
        }
      }
    }

    return result ;
  }

  public boolean isValid(String str){

    Stack<Character> stack = new Stack<>() ;

    for(int i=0 ; i<str.length(); i++){
      if(str.charAt(i) == '('){
        stack.add('(');
      }else if(stack.isEmpty() && str.charAt(i) == ')'){
        return false ;
      }else if(str.charAt(i) == ')'){
        stack.pop() ;
      }
    }
    return stack.isEmpty() ;
  }
}