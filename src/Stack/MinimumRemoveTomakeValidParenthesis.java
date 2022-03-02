package Stack;

class MinimumRemoveTomakeValidParenthesis {
    public static void main(String[] args) {
       String s = "l(e(e(t(c)o)de)";
        System.out.println(minRemoveToMakeValid(s));
    }
    public static String minRemoveToMakeValid(String s) {
        StringBuilder sb=new StringBuilder();
        int open=0;
        for (char ch:s.toCharArray()){
            if (ch=='('){
                open++;
            }else if(ch==')'){
                if (open==0)continue;
                open--; }
            sb.append(ch);
        }
        StringBuilder ans=new StringBuilder();
        for (int i=sb.length()-1;i>=0;i--){
            if (sb.charAt(i)=='('&&open-->0)continue;
            ans.append(sb.charAt(i));
        }
        return ans.reverse().toString();
    }
}