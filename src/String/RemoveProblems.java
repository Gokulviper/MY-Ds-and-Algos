package String;

import java.util.*;

public class RemoveProblems {
    public static void main(String[] args) {
    }
    public String removeDuplicateLetters(String s) {
        Set set=new HashSet();
        char ch[]=s.toCharArray();
        Arrays.sort(ch);
        for(int i=0;i<ch.length;i++){
            set.add(ch[i]);
        }
        String ss="";
        List ans=new ArrayList();
        ans.addAll(set);
        for(int i=0;i<ans.size();i++){
           ss+= ans.get(i);

        }
        return ss;

    }
    public static String removeKdigits(String str, int k) {
        //algorithm
        //create stack
        //push the element before check for the all elemnets in stack
        //if the currentElement lesser then elements in stack then remove the element  in stack
        //special case: if the stack is dont the add the 0 beacause that would be the leading zero
        //if traverse the string k not equal zero remove last elements in stack
        //if stack is empty the given length and the k length is equal return 0
        //after you get the all elements and reverse
        char []nums = str.toCharArray();
        int n = nums.length;

        Stack<Character>st = new Stack<>();

        for(int i=0;i<n;i++){

            // remove strictly decreasing sequence

            while(!st.isEmpty() && st.peek()>nums[i] && k-- >0)
                st.pop();

            // prevent leading zeros
            if (st.isEmpty() && nums[i] == '0') continue;
            st.push(nums[i]);
        }

        // k is not zero then remove last digits from the sequence
        while(!st.isEmpty() && k-- >0){
            st.pop();
        }

        if(st.isEmpty()) return "0";

        StringBuilder sb= new StringBuilder();

        while(!st.isEmpty())
            sb.append(st.pop());

        return sb.reverse().toString();
    }
}
