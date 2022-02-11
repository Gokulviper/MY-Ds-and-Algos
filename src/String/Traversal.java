package String;
import java.util.*;
public class Traversal {
    public static void main(String[] args) {
        System.out.println(conver   ("PAYPALISHIRING",3));
    }
    public static String conver(String s, int numRows) {
        if(numRows==1)return s;
        List<StringBuilder> rows=new ArrayList<>();
        for(int i=0;i<Math.min(numRows,s.length());i+=1){
            rows.add(new StringBuilder());
        }
        int currRow=0;
        boolean goingDown=false;
        for(char ch:s.toCharArray()){
            rows.get(currRow).append(ch);
            if(currRow==0){
                goingDown=true;
            }else if(currRow==numRows-1){
                goingDown=false;
            }
            if (goingDown){
                currRow++;
            }else {
                currRow--;
            }
        }
      StringBuilder sb=new StringBuilder();
        for(StringBuilder row:rows){
            sb.append(row);
        }

        return sb.toString();

    }
    public static String convert(String s, int numRows) {

        if (numRows == 1) return s;

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++)
            rows.add(new StringBuilder());

        int curRow = 0;
        boolean goingDown = false;


        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
         //   if (curRow == 0 || curRow == numRows - 1){
           //     goingDown = !goingDown;
         //   }
         //   curRow += goingDown ? -1 : 1;
            if(curRow==0){
                goingDown=true;
            }else if(curRow==numRows-1){
                goingDown=false;
            }
            if(goingDown){
                curRow++;
            }else {
                curRow--;
            }

        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) ret.append(row);
        return ret.toString();
    }
}
