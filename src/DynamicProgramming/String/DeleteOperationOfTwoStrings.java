package DynamicProgramming.String;

class DeleteOperationOfTwoStrings {
    public int minDistance(String word1, String word2) {
        int num=lcs(word1,word2);
        int ans=0;
        ans+=Math.abs(word1.length()-num);
        ans+=Math.abs(word2.length()-num);
        return ans;
    }
             int lcs(String s1, String s2){
   int n=s1.length(),m=s2.length();
int []prev=new int[m+1],cur=new int[m+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1))cur[j]=1+prev[j-1];
                else cur[j]=Math.max(prev[j],cur[j-1]);
            }
            prev=cur.clone();
        }
        return prev[m];

   //
    }
}