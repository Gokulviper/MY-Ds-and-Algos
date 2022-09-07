package OOP;
class get{
    private  int id;
    private String name;
    private int number;

    public get(int id, String name, int number) {
        this.id = id;
        this.name = name;
        this.number = number;
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
        get g=new get(34,"gokul",34);
   //     g.setNumber(777);
        System.out.println(g.getNumber());
        StringBuilder sb=new StringBuilder();
        System.gc();
        Integer a=34;
        int b=a;
        int c=34;
      //  binarySearch();
    }


}
