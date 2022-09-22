package Graph.Problems.unionfind;
class dis{
    int count;
    int[]par;
    int[]rank;
    dis(int n){
        count=n;
        par=new int[n];
        rank=new int[n];
        for(int i=0;i<n;i++){
            par[i]=i;
            rank[i]=1;
        }
    }
    int findPar(int x){
        if(x==par[x])return x;
        return  par[x]=findPar(par[x]);
    }
    void union(int u,int v){
        int node1=findPar(u),node2=findPar(v);
        if(node1==node2)return ;
        if(rank[node1]<rank[node2]){
            par[node2]=node1;
        }else if(rank[node1]>rank[node2]){
            par[node1]=node2;
        }else{
            par[node1]=node2;
            rank[node2]++;
        }
        count--;
    }
    int count(){
        return count;
    }

}
class NumberOfProvinces {
    public int findCircleNum(int[][] isConnected) {
    int n=isConnected.length;
        int m=isConnected[0].length;
        dis d=new dis(n);
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
               if(i<j && isConnected[i][j]==1){
                    d.union(i,j);
                }
            }
        }
        return d.count();
}
}