package String.HashinG;

class FirstUniqueChar {
    public static void main(String[] args) {

    }
    public int firstUniqChar(String s) {
        int[]hash=new int[26];
        for(char ch:s.toCharArray()){
            hash[ch-'a']++;
        }
        for(int i=0;i<s.length();i++){
            if(hash[s.charAt(i)-'a']==1){
                return i;
            }
        }
        return -1;
    }
    public int firstUniqChar2(String s) {
        //brute force
        for(int i=0;i<s.length();i++){
            int count=0;
            for(int j=0;j<s.length();j++){
                if(s.charAt(i)==s.charAt(j)){
                    count++;
                }
                
            }
            if(count==1){
                return i;
            }
            
        }
        return -1;
    }
}