package PatternQuestions;

public class ConcentricPattern {

    public static void main(String[] args) {

    }
    public void printP(int n){
        int size = 2 * n - 1;
//inner loop
        for (int i = 1; i <= size; i++) {
//outer loop
            for (int j = 1; j <= size; j++) {
//calculates and prints the values for pattern
                int val=Math.abs(i-n)+1;
                int val2=Math.abs(j-n)+1;
                System.out.print(Math.max(val,val2));
            }
            System.out.println();
        }


    }
}
