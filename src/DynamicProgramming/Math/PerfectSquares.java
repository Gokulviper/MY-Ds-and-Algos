package DynamicProgramming.Math;

import java.util.*;

class PerfectSquares {
    public int numSquares(int n) {
        if(n <= 1)
            return n;
        
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i*i <= n; i++) {
            list.add(i*i);
        }
        
        return recurion(list, list.size() - 1, n);
    }
    
    private int recurion(List<Integer> list, int index, int target) {
        if(target == 0)
            return 0;
        if(index == 0)
            return target; //Since we need to form the target with only the number 1 (the number at the 0th index of the list)
        
        int notPick = recurion(list, index-1, target);
        
        int pick = Integer.MAX_VALUE;
        if(target >= list.get(index))
            pick = 1 + recurion(list, index, target - list.get(index));
        
        return Math.min(notPick, pick);
    }
    private int memo(List<Integer> list, int index, int target, int[][] memo) {
        if(target == 0)
            return 0;
        if(index == 0)
            return target;

        if(memo[index][target] != -1)
            return memo[index][target];

        int notPick = memo(list, index-1, target, memo);

        int pick = Integer.MAX_VALUE;
        if(target >= list.get(index))
            pick = 1 + memo(list, index, target - list.get(index), memo);

        memo[index][target] = Math.min(notPick, pick);
        return memo[index][target];
    }
    public int tabulation(int n) {
        if(n <= 1)
            return n;

        List<Integer> list = new ArrayList<>();
        for(int i = 1; i*i <= n; i++) {
            list.add(i*i);
        }

        int[][] memo = new int[list.size()][n+1];
        for(int target = 0; target <= n; target++) {
            memo[0][target] = target;
        }

        for(int index = 1; index < list.size(); index++) {
            for(int target = 1; target <= n; target++) {
                int notPick = memo[index-1][target];
                int pick = Integer.MAX_VALUE;
                if(target >= list.get(index))
                    pick = 1 + memo[index][target-list.get(index)];

                memo[index][target] = Math.min(pick, notPick);
            }
        }

        return memo[list.size()-1][n];
    }
}