package DynamicProgramming.Array;
/*
you find the all posible ways so the thing you want to check the balance days you can reach
make dummy pointer and so f
* first make one step recursion call so that not take any conditon because tarvelling day by day
* next the weekpass is 7 days inorder do that before you check
  - make dummy pointer and check for next seven  days available
  - not mandatory all seven days in the array
  - example current index -5 get 7 day pass 12 day is last valid day
  - so you check 12 and less then members avialable in the array
  - so coudl iterate that elements for seven day pass
  -sometimes curret index -5 the array having next elements only 7 so simply cover that
	element that is over
*same process for 30 days
*/
class MinCostForTickets {
    public static void main(String[] args) {
        int[]days={1,4,6,7,8,20};
        int cost[]={2,7,15};
          mincostTickets(days,cost);
    }
    public static int mincostTickets(int[] days, int[] costs) {
        // recursive     
        // return recursive(days, costs, 0);
        
        // Memoized
        // int[] dp = new int[days.length];
        // return memoized(days, costs, 0, dp);
        
        
        // Tabulation
        return recursive(days, costs,0);
    }
    
    public static int recursive(int[] days, int[] cost, int index){
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
    
    public static int memoized(int[] days, int[] cost, int index , int[] dp){
        
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
    
    public static int tabulation(int[] days, int[] cost){
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