package Stack;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicStampedReference;

public class RemoveAllAdjacentDuplicatesInString {
    public static void main(String[] args) {
        //"pbbcggttciiippooaais"
        //2
        System.out.println(removeDuplicates("pbbcggttciiippooaais",2));
    }
    public static String removeDuplicates(String s, int k) {
        Stack<int[]>stack=new Stack<>();
        for (char ch:s.toCharArray()){
            if(!stack.isEmpty()&& stack.peek()[0]==ch){
                stack.peek()[1]++;
            }else{
                stack.push(new int[]{ch,1});
            }
            if (stack.peek()[1]==k){
                stack.pop();
            }
        }
        StringBuilder sb=new StringBuilder();
        while (!stack.isEmpty()){
            int[]top=stack.pop();
            while (top[1]-->0){
                sb.append((char) top[0]);
            }
        }
        return sb.reverse().toString();
    }
    public static String removeDuplicatesNotWorkingAllTestCases(String s, int k) {
        //this is a  medium problem
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (char ch : map.keySet()) {
            int val = map.get(ch);
            if (val < k) continue;
            if (val>k&&val%k==0){
                val = val % k - k;
            }else {
               val=val-k;
            }
            if (val == 0) {
                map.put(ch, val);
            } else {
                map.put(ch, val);
            }
        }
        StringBuilder sb=new StringBuilder();
        for (char ch:s.toCharArray()){
            if (map.get(ch)>0){
                sb.append(ch);
                map.put(ch,map.getOrDefault(ch,0)-1);
            }
        }
        return sb.toString();
    }

    public static String removeDuplicates(String str) {
        Stack<Character>stack=new Stack<>();
        for (char ch: str.toCharArray()){
            if (!stack.isEmpty()&&stack.peek()==ch){
                stack.pop();
            }else{
                stack.push(ch);
            }
        }
        StringBuilder sb=new StringBuilder();
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
