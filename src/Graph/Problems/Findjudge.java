package Graph.Problems;

class Findjudge {
    public int findJudge(int n, int[][] trust) {
        int[]nums=new int[n+1];
        for(int i=0;i<trust.length;i++){
            nums[trust[i][0]]--; //outdrgree
            nums[trust[i][1]]++; //indegree
            
        }
        for(int i=1;i<=n;i++){
            if(nums[i]==n-1){
                return i;
            }
        }
        return -1;
        
    }
}