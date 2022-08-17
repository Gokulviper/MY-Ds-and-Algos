package Treee.problems.BinaryTreeProblems;

//import static jdk.nashorn.internal.objects.Global.print;

public class Pattern {
    public static void main(String[] args) {
        print(6);
    }
    static void print(int n){
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <5 ; j++) {
                if (i==0||i==n-1){
                    System.out.print("* ");
                }else{
                    if (j==0||j==4){
                        if (j==4) System.out.print(" *");
                        else
                        System.out.print("* ");
                    }else{
                        System.out.print(" ");
                    }
                }
            }
            System.out.println();
        }
    }
}
