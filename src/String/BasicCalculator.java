package String;

class BasicCalculator {
    public int calculate1(String s) {
      if(s==null||s.isEmpty())return 0;
      int currentNumber=0,lastNumber=0,ans=0;
      char sign='+';
      for(int i=0;i<s.length();i++){
          char current=s.charAt(i);
          if(Character.isDigit(current)){
              currentNumber=(currentNumber*10)+(current-'0');
          }
          if(!Character.isDigit(current)&&!Character.isWhitespace(current)||i==s.length()-1){
              if(sign=='+'||sign=='-'){
                  ans+=lastNumber;
                  lastNumber=sign=='+'?currentNumber:-currentNumber;
              } else if (sign == '*') {

                  lastNumber=lastNumber*currentNumber;

              } else if (sign == '/') {

                  lastNumber=lastNumber/currentNumber;
              }
              sign=current;
              currentNumber=0;
          }


      }
      ans+=lastNumber;
return ans;
    }
}
