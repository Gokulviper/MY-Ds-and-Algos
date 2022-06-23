package BitManipulations.basic;

public class CheckTwoIntersAreOppositeSigns {
    public static void main(String[] args) {
        System.out.println(chekcBothareopposie(-56,56)); ;
    }

    private static boolean chekcBothareopposie(int a, int b) {
        System.out.println(a^b);
    return (a^b)<0;
    }

}
