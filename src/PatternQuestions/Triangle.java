package PatternQuestions;

public class Triangle {
    public static void main(String[] args) {
       NumTriangle(5);
    }
    private static void startTriangle(int n){

        for (int i = 1; i <=n ; i++) {
            for (int j = 5; j >=i ; j--) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    private static void NumTriangle(int n){

        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=i ; j++) {
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
}
