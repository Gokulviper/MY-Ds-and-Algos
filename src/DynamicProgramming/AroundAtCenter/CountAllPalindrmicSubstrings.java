package DynamicProgramming.AroundAtCenter;

class CountAllPalindrmicSubstrings {
    public int countSubstrings(String s) {
        if(s.length()==0)return 0;
        int ans=0;
        for(int i=0;i<s.length();i++){
            ans+=a(s,i,i);
           ans+=a(s,i,i+1);
        }
        return ans;
    }
    int a(String s,int left,int right){
        int c=0;
        while(left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)){
            left--;
            right++;
            c++;
        }
        return c;
    }
}