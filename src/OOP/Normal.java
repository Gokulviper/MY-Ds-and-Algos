package OOP;

 class Normal {
     private int id;
     private int number;
     private void run(){
         System.out.println("sut");
     }
       static class innner{

          public  void main(String[] args) {
              Normal n=new Normal();
              int a=n.id;

          }
    }
}
class real{
    public static void main(String[] args) {
        Normal.innner n=new Normal.innner();
        n.main(new String[]{"fd"});
    }
}
