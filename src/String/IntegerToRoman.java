package String;

public class IntegerToRoman {
    public static void main(String[] args) {
        System.out.println(intToRoman(1200));
    }
    public static String intToRoman(int num) {
        //algorithm
        //very easy take the number is greater then the intcode number
        //so we add that number symbol in string and
        //and find the next number in the string
        int[] intcode={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[]code={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<intcode.length;i++){
            while(num>=intcode[i]){
                sb.append(code[i]);
                num-=intcode[i];
            }
        }
        return sb.toString();
    }
}
