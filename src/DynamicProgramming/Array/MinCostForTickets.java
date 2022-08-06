package DynamicProgramming.Array;

class MinCostForTickets {
    public int mincostTickets(int[] days, int[] costs) {
        // recursive     
        // return recursive(days, costs, 0);
        
        // Memoized
        // int[] dp = new int[days.length];
        // return memoized(days, costs, 0, dp);
        
        
        // Tabulation
        return tabulation(days, costs);
    }
    
    public int recursive(int[] days, int[] cost, int index){
        if(index >= days.length) return 0;
        int a = cost[0] + recursive(days, cost, index + 1);
        int pointer = index;
        while(pointer < days.length && days[pointer] < days[index] + 7) pointer++;
        int b = cost[1] + recursive(days, cost, pointer);
        pointer = index;
        while(pointer < days.length && days[pointer] < days[index] + 30) pointer++;
        int c = cost[2] + recursive(days, cost, pointer);
        return Math.min(a, Math.min(b,c));

    }
    
    public int memoized(int[] days, int[] cost, int index , int[] dp){
        
        if(index >= days.length) return 0;
        
        if(dp[index] != 0) return dp[index];
        
        
        int a = cost[0] + memoized(days, cost, index + 1, dp);
        
        int pointer = index;
        
        while(pointer < days.length && days[pointer] < days[index] + 7) pointer++;
        
        int b = cost[1] + memoized(days, cost, pointer,dp);
        
        pointer = index;
        
        while(pointer < days.length && days[pointer] < days[index] + 30) pointer++;
        
        int c = cost[2] + memoized(days, cost, pointer, dp);
        
        
        return dp[index] =  Math.min(a, Math.min(b,c));        
    }
    
    public int tabulation(int[] days, int[] cost){
        int n = days.length;
        int[] dp = new int[n + 1];
        
        for(int i = n - 1 ; i >=0 ; i --){
            int a = cost[0] + dp[i + 1];
            
            int pointer = i;
            
            while(pointer < n && days[pointer] < days[i] + 7) pointer++;
            
            int b = cost[1] + dp[pointer];
            
            pointer = i;
            
            while(pointer < n && days[pointer] < days[i] + 30) pointer++;
            
            int c = cost[2] + dp[pointer];
            
            dp[i] = Math.min(a, Math.min(b,c));
        }
        
        return dp[0];
    }
}