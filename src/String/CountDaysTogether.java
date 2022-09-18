package String;

class CountDaysTogether {
    public static void main(String[] args) {
       fun(3);
    }

    private static void fun(int n) {
        int size=2*n-1;
        int frontStars=2;
        int endStars=2;
        int numberLoopSize=1;
        for (int i = 0; i <size ; i++) {
            int k=0;
           ;
            for ( int j = 0; j <frontStars ; j++) {
                System.out.print("*");
                k++;
            }
            int number=n;
            for (int j = 0; j <numberLoopSize ; j++) {
                if (k<n/2+1){
                    System.out.print(number--);
                }else{
                    System.out.print(number++);
                }
                k++;
            }
            for (int j = 0; j <endStars ; j++) {
                System.out.print("*");
            }
            System.out.println();
           if (i<n/2+1){
               frontStars--;
               endStars--;
               numberLoopSize+=2;
           }else{
               frontStars++;
               endStars++;
               numberLoopSize-=2;
           }
            System.out.println();
        }
    }

}