package DynamicProgramming.String.PallindromeProblems;

class Palindromepartition2 {
    int minCut(String s , int i , int n , int[] dp){
        if(i == n)  return 0;

        if(dp[i] != -1)     return dp[i];

        int mini = Integer.MAX_VALUE;
        for(int ind = i ; ind < n ; ind++){
            if(pal(s,i , ind))
            {
                mini = Math.min(mini , 1+minCut(s , ind+1 , n , dp));
            }
        }

        return dp[i] = mini;
    }

    public int tabulation(String s) {
        int[]dp=new int[s.length()+1];
   
        if(s.length()==0||s.length()==1)return 0;
   
        for(int i=s.length()-1;i>=0;i--){
             int min=Integer.MAX_VALUE;
            for(int j=i;j<s.length();j++){
      
            if(pal(s,i,j)){
            min=Math.min(min,1+dp[j+1]);
            }
        }
        dp[i]= min;
        }
        return dp[0]-1;
    }
    boolean pal(String s,int start,int end){
        while(start<end){
          if(s.charAt(start++)!=s.charAt(end--)){
return false;
          }
        }
        return true;
    }
}