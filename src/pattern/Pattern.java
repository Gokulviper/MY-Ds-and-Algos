package pattern;
//step 1: how many lines you want this for outer for loop
//step 2:identiify  for every row no
    //*how mamny cols are there
    //types of elements in there
public class Pattern {
    public static void main(String[] args) {
        patten(6);
       }

public static  void patten(int n){
        for(int i=1;i<=n;i++){
            for(int j=n;j>=i;j--){
                System.out.print(" "+"*");
            }
            System.out.println();
        }
}

}
