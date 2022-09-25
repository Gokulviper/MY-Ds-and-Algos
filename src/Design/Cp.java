package Design;

import java.util.Scanner;

public class Cp {
    public static void main(String[] args) {
        for (int i = 1; i*i <56 ; i++) {
            System.out.println(i*i);
        }
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {

            int a=sc.nextInt();
            int b=sc.nextInt();
            int x=sc.nextInt();
            boolean ansGot=false;
            if(a==b) {System.out.println("YES");
                ansGot=true;}
            else if(b<a){
                while (a>=b){
                    if (a==b){
                        ansGot=true;
                        System.out.println("yes");
                    }
                    a-=x;
                    b+=x;
                }
            }
            else{
                while (a<=b){
                    if (a==b){
                        ansGot=true;
                        System.out.println("YES");
                    }
                    a+=x;
                    b-=x;
                }
            }
            if (!ansGot) System.out.println("NO");
        }
    }
}
