package Math;

public class ReverseNumber {
    public static void main(String[] args) {
        int num=120;
        System.out.println(reverse(num));

    }
    public static int reverse(int num) {
        //avoid leading zeros
        //maintainn negative number
        int check=num;
        int ans=0;
        while (num!=0){
            ans=ans*10+num%10;
            num/=10;
        }
     //   if (check<0){
    //        ans*=-1;
    //    }
       return ans;
    }

}
