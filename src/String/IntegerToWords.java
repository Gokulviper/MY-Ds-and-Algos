package String;

import java.util.HashMap;

class IntegerToWords {
    public static void main(String[] args) {
        System.out.println(convertToWords1(1024));
    }
    String convertToWords2(long n) {
        // code here

        String str = "";
        for(int i=1; n>0; i++){

            // when "i" will be at 100th place
            // it will get the digit at 100th place
            if(i==2){
                int m = (int)(n%10);
                n/=10;

                // if string is empty 'and' will not be added to the string
                // i.e. at 100,200
                if(str.length()==0 ){
                    str = numberToWord( m, i) + str;
                }
                else{
                    str = numberToWord( m, i)+"and " + str;
                }

            }
            else{
                int m = (int)(n%100);
                n /=100;
                str = numberToWord( m, i) + str;
            }
        }

        if(str.charAt(str.length()-1) != ' '){
            return str +" ";
        }

        return str;

    }

    public static String numberToWord( int num, int i){
        if(num==0) return "";

        // for number from 1 to 19
        String[] ones = {"one", "two", "three", "four", "five", "six", "seven",
                "eight", "nine", "ten", "eleven", "twelve", "thirteen",
                "fourteen", "fifteen", "sixteen", "seventeen", "eighteen",
                "nineteen"
        };

        // for 20 ,30, ..., 90
        String[] tens = {"twenty", "thirty", "forty", "fifty", "sixty", "seventy",
                "eighty", "ninety"
        };

        String[] zeros = { " hundred ", " thousand ", " lakh ", " crore "};

        String rs = "";
        if( num<=19 ){

            rs = rs + ones[num-1];
        }
        else{
            int m = num%10;
            num /= 10;

            rs = tens[num-2] ;

            if(m>0){
                rs = rs+" "+ ones[m-1];
            }
        }

        // here hundred ,thousand will be added to the string
        // accourding to the value of 'i'
        if( i>=2){
            rs  = rs + zeros[i-2 ];
        }


        return rs;
    }
    static   String convertToWords1(long num) {
        HashMap<Integer,String> hash = new HashMap<>();
        hash.put(0,"");
        hash.put(1,"one ");hash.put(2,"two ");hash.put(3,"three ");hash.put(4,"four ");
        hash.put(5,"five ");hash.put(6,"six ");hash.put(7,"seven ");hash.put(8,"eight ");
        hash.put(9,"nine ");hash.put(10,"ten ");hash.put(11,"eleven ");hash.put(12,"twelve ");
        hash.put(13,"thirteen ");hash.put(14,"fourteen ");hash.put(15,"fifteen ");hash.put(16,"sixteen ");
        hash.put(17,"seventeen ");hash.put(18,"eighteen ");hash.put(19,"nineteen ");
        hash.put(20,"twenty ");hash.put(30,"thirty ");hash.put(40,"forty ");
        hash.put(50,"fifty ");hash.put(60,"sixty ");hash.put(70,"seventy ");
        hash.put(80,"eighty ");hash.put(90,"ninety ");hash.put(100,"hundred ");
        hash.put(1000,"thousand ");hash.put(100000,"lakh ");hash.put(10000000,"crore ");
  String ans="";
  int n=(int) num;
  if (n>=10000000){
      int c=n/10000000;
      if (c>=20)ans+=hash.get(c-(c%10))+hash.get(c%10)+"crore";
      else ans+=hash.get(c)+"crore";
      n%=10000000;
  }
        if (n>=100000){
            int c=n/100000;
            if (c>=20)ans+=hash.get(c-(c%10))+hash.get(c%10)+"lakh";
            else ans+=hash.get(c)+"lakh";
            n%=100000;
        }
        if (n>=1000){
            int c=n/1000;
            if (c>=20)ans+=hash.get(c-(c%10))+hash.get(c%10)+"thousand";
            else ans+=hash.get(c)+"thousand";
            n%=1000;
        }
        if (n>=100){
            int c=n/100;

           ans+=hash.get(c-(c%10))+hash.get(c%10)+"hundred";
            n%=100;
        }
        if (n>=20&&num>=100){
            ans+="and"+hash.get(n-(n%10))+hash.get(n%10);
        }else if(n>0&&num>=100)ans+="and"+hash.get(n);
        else if(num<100){
            if (num>=20)ans+=hash.get(n-(n%10))+hash.get(n%10);
            else ans+=hash.get(n);
        }

  return ans;
    }
 static   String convertToWords(long num) {
       HashMap<Integer,String> hash = new HashMap<>();
       hash.put(0,"");
       hash.put(1,"one ");hash.put(2,"two ");hash.put(3,"three ");hash.put(4,"four ");
       hash.put(5,"five ");hash.put(6,"six ");hash.put(7,"seven ");hash.put(8,"eight ");
       hash.put(9,"nine ");hash.put(10,"ten ");hash.put(11,"eleven ");hash.put(12,"twelve ");
       hash.put(13,"thirteen ");hash.put(14,"fourteen ");hash.put(15,"fifteen ");hash.put(16,"sixteen ");
       hash.put(17,"seventeen ");hash.put(18,"eighteen ");hash.put(19,"nineteen ");
       hash.put(20,"twenty ");hash.put(30,"thirty ");hash.put(40,"forty ");
       hash.put(50,"fifty ");hash.put(60,"sixty ");hash.put(70,"seventy ");
       hash.put(80,"eighty ");hash.put(90,"ninety ");hash.put(100,"hundred ");
       hash.put(1000,"thousand ");hash.put(100000,"lakh ");hash.put(10000000,"crore ");

   String ans = "";
   int n = (int)num;
   if(n>=10000000){
       int c = n/10000000;
       if(c>=20) ans = ans + hash.get(c-(c%10)) + hash.get(c%10) + "crore ";
       else ans = ans + hash.get(c) + "crore ";
       n= n%10000000;
   }
   if(n>=100000){
       int c = n/100000;
       if(c>=20) ans = ans + hash.get(c-(c%10)) + hash.get(c%10) + "lakh ";
       else ans = ans + hash.get(c) + "lakh ";
       n= n%100000;
   }
   if(n>=1000){
       int c = n/1000;
       if(c>=20) ans = ans + hash.get(c-(c%10)) + hash.get(c%10) + "thousand ";
       else ans = ans + hash.get(c) + "thousand ";
       n= n%1000;
   }
   if(n>=100){
       int c = n/100;
      ans = ans + hash.get(c) + "hundred ";
      n=n%100;
   }
   if(n>=20 && (int)num>=100 ){
        ans = ans + "and " + hash.get(n-(n%10)) + hash.get(n%10);
   }
  else if(n>0 && (int)num>=100 ) ans = ans +"and "+ hash.get(n);
   else if(num<100){
       if(num>=20)  ans = ans + hash.get(n-(n%10)) + hash.get(n%10);
       else ans = ans + hash.get(n);
   }
 
  return ans;
}
}