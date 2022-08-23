package ArrayProblems.Sorting.GeneralAlgorithms;

public class P {
    public static void main(String[] args) {
        String s="abccccdd";
        s=s.toUpperCase();
        System.out.println(longestPalindrome(s));
        System.out.println(1/2);
    }
    public static int longestPalindrome(String s) {
        int count[]=new int[128];
        for(char ch:s.toCharArray()){
            count[ch]++;
        }

        int sum=0;
        for(int v:count){
            sum+=v/2*2;
            if(sum%2==0&&v%2==1){
                sum++;
            }
        }
        return sum;
    }
}
