package DynamicProgramming;

import java.awt.print.PrinterGraphics;

public class FrogJump {
    public static void main(String[] args) {
        int[]jumpLengths={10,20,40,50,10};
        System.out.println(findShortTestPath(jumpLengths, jumpLengths.length-1));

    }

    private static int findShortTestPath(int[] jumps, int i) {
        if (i==0)return 0;
        int left=findShortTestPath(jumps,i-1)+Math.abs(jumps[i]-jumps[i-1]);
        int right=Integer.MAX_VALUE;
        if (i>1){right=findShortTestPath(jumps,i-2)+Math.abs(jumps[i]-jumps[i-2]);}
        return Math.min(left,right);
    }
}
