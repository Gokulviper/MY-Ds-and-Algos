package OOP;

public class OverLoading {
    public static void main(String[] args) {
      OverLoading o=new OverLoading();
      o.add(34,(float) 66.56,45);
    }

    public static void main(String[] args,int b) {
        System.out.println("second");
    }
    int add(int a,int b){
        return a+b;
    }
      int add(int a){
        return (int) (a);
    }
    static  int add(int a,float b,int c){
        return (int) (a+b+c);
    }
}
