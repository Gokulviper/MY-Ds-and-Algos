package Math;

public class AddBinary {
    public static void main(String[] args) {

    }
    public String addBinary(String s1, String s2) {
        StringBuilder sb=new StringBuilder();
        int i=s1.length()-1,j=s2.length()-1,carry=0;
        while(i>=0||j>=0||carry>0){
            int num1=(i>=0)?s1.charAt(i--)-'0':0;
            int num2=(j>=0)?s2.charAt(j--)-'0':0;
            int val=num1+num2+carry;
            sb.insert(0,val%2);
            carry=val/2;
        }
        return sb.toString();
    }
}
