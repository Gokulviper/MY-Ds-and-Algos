package String;

import static String.ConversionToIntegers.sum;

public class MultiplyStrings {
    public static void main(String[] args) {
        int num='0';
        char ch='3';
        System.out.println((int)ch);

    }
    String multiply(String num1,String num2){
        if (num1.equals("0")||num2.equals("0"))return "0";
        StringBuilder ans=new StringBuilder();
        StringBuilder addTheZeros=new StringBuilder();
        for(int i=num2.length();i>=0;i--){
            int num=num2.charAt(i)-'0';
            StringBuilder  mul=multiplyTheString(num,num1);
            mul.append(addTheZeros);
            addTheZeros.append("0");
            ans=additon(ans,mul);
        }
        return ans.toString();
    }

    private StringBuilder additon(StringBuilder num1, StringBuilder num2) {
        StringBuilder ans=new StringBuilder();
        int i=num1.length()-1,j=num2.length()-1,carry=0;
        while (i>=0||j>=0||carry>0){
            int val1=i>=0?num1.charAt(i)-'0':0;
            int val2=j>=0?num2.charAt(j)-'0':0;
            int add=val1+val2+carry;
            ans.insert(0,add%10);
            carry=add/10;
            i--;
            j--;
        }
        return ans;

    }

    private StringBuilder multiplyTheString(int num, String s) {
        StringBuilder ans=new StringBuilder();
        int carry=0;
        for (int i = s.length()-1; i >=0; i--) {
            int last=s.charAt(i)-'0';
            int val=num*last+carry;
            ans.insert(0,val%10);
            carry=val/10;
        }
        if (carry>0){
            ans.insert(0,carry);
        }
        return ans;
    }
}
