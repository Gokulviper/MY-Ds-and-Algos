package String;

import java.util.HashMap;

class IntegerToWords {
   String convertToWords(long l) {
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

   String out = "";
   int n = (int)l;
   if(n>=10000000){
       int c = n/10000000;
       if(c>=20) out = out + hash.get(c-(c%10)) + hash.get(c%10) + "crore ";
       else out = out + hash.get(c) + "crore ";
       n= n%10000000;
   }
   if(n>=100000){
       int c = n/100000;
       if(c>=20) out = out + hash.get(c-(c%10)) + hash.get(c%10) + "lakh ";
       else out = out + hash.get(c) + "lakh ";
       n= n%100000;
   }
   if(n>=1000){
       int c = n/1000;
       if(c>=20) out = out + hash.get(c-(c%10)) + hash.get(c%10) + "thousand ";
       else out = out + hash.get(c) + "thousand ";
       n= n%1000;
   }
   if(n>=100){
       int c = n/100;
      out = out + hash.get(c) + "hundred ";
      n=n%100;
   }
   if(n>=20 && (int)l>=100 ){
        out = out + "and " + hash.get(n-(n%10)) + hash.get(n%10);
   }
  else if(n>0 && (int)l>=100 ) out = out +"and "+ hash.get(n);
   else if((int)l<100){
       if((int)l>=20)  out = out + hash.get(n-(n%10)) + hash.get(n%10);
       else out = out + hash.get(n);
   }
 
  return out;
}
}