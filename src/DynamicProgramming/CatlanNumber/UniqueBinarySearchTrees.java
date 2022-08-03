package DynamicProgramming.CatlanNumber;

class UniqueBinarySearchTrees {
    public static void main(String[] args) {
        System.out.println(numTrees(5));
    }
    public int Recursion(int n) {
        int ans=0;
        if(n<=1)return 1;
        for(int i=0;i<n;i++){
            ans+=numTrees(i)*numTrees(n-i-1);
        }
        return ans;
    }
    public static int numTrees(int n) {
        
      
        int dp[] = new int[n+1];
        
		
        dp[0] = 1; //initialize
        dp[1] = 1; // because with 1 node there is only one way, in centre
//always keep 1 in centre

//2 -> 1*1 + 1*1 ->  | 0 on left, 1 in centre , 1 on right ++ 1 on right, 1 in centre + 0 on left..
//3 -> 0*2 + 1*1 + 2*0  | same as above
//4 -> 0*3 + 1*2 + 2*1 + 1*0 | same as above

// dp[0] * dp[1] + dp[1][0]
        
        for(int i=2;i<=n ;i++){
            for(int j=1;j<=i;j++){
                dp[i]+=dp[j-1]*dp[i-j];
            }
        }
        
        return dp[n];
    }
}