package DynamicProgramming.String.PallindromeProblems;

class Palindromepartition2 {
    public int minCut(String s) {
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