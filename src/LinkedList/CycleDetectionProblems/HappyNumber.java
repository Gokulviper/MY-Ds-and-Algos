package LinkedList.CycleDetectionProblems;

class HappyNumber {
    public boolean isHappy(int n) {
         int slow=n;
        int fast=n;
        do{
            slow=find(slow);
            fast=find(find(fast));
        }while(slow!=fast);
        
        return slow==1;
    }
    int find(int n){
        int ans=0;
        while(n>0){
            int mod=n%10;
            ans+=mod*mod;
            n/=10;
        }
        return ans;
    }
}