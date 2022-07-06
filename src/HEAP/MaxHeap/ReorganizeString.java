package HEAP.MaxHeap;

import java.util.PriorityQueue;

class ReorganizeString {

   static public class pair {
        char ch;
        int f;

        pair(char ch, int f) {
            this.ch = ch;
            this.f = f;
        }
    }

    public static void main(String[] args) {
        System.out.println(reorganizeString("aaab"));
    }

    public static String reorganizeString(String s) {
        int[] map = new int[26];
        PriorityQueue<pair> pq = new PriorityQueue<>((a, b) -> (b.f - a.f));
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i) - 'a']++;   //mapping all the elements.
        }

        //adding elements to the heap

        for (int i = 0; i < map.length; i++) {
            if (map[i] > 0) {
                pq.add(new pair((char) ('a' + i), map[i]));
            }
        }//appending string while blocking the element that is added thats why we added one
        // elemnt before to create block
        StringBuilder ans = new StringBuilder();
        pair block = pq.poll();
        ans.append(block.ch);
        block.f--;
        while (pq.size() > 0) {
            pair temp = pq.poll();
            ans.append(temp.ch);//there in same element added together so that is the first pop ed
            //from pq after insering this that have freq then add the block
            temp.f--;
            if (block.f > 0) {
                pq.add(block);
            }
            block = temp;
        }
        if (block.f > 0) {
            return "";
        }

        return ans.toString();
    }
}