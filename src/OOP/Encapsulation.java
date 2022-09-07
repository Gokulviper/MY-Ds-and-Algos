package OOP;
class get{
    private static int id;
    private String name;
    private int number;

    public get(int id, String name, int number) {
        this.id = id;
        this.name = name;
        this.number = number;
    }

    public  void main(String[] args) {
        System.out.println(id);
        System.out.println(this.name);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
public class Encapsulation {
    public static void main(String[] args) {
        Abstraction a=new Abstraction() {
            @Override
            public void start() {

            }

            @Override
            public void df() {

            }

            @Override
            public void dg() {

            }

            @Override
            public void dgk() {

            }

            @Override
            public void fg() {

            }
        };
        get g=new get(34,"gokul",34);
   //     g.setNumber(777);
        System.out.println(g.getNumber());
        StringBuilder sb=new StringBuilder();
        System.gc();
       // Integer a=34;
      //  int b=a;
        int c=34;
      //  binarySearch();
    }


}
