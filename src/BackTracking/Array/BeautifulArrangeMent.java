package BackTracking.Array;
/*
simply make a recurvie call on 1 to n check every possibkle making perumutation the current index is divident of nums[i] so that is make the next number in the current array
the array calls  make the permutation and checks correctly so initailly wrong permutation avoided initaially
 */
class BeautifulArrangeMent {
    int count=0;
    public int countArrangement(int n) {
        boolean[] vis=new boolean[n+1];
        permute(vis,1,n);
        return count;
    }
    void permute(boolean[]vis,int index,int n){
        if(index>n){
            count+=1;
        }
        for(int i=1;i<=n;i++){
            if(!vis[i]&&(i%index==0||index%i==0)){
                vis[i]=true;
                permute(vis,index+1,n);
                vis[i]=false;
            }
        }
    }
}