package Math;

public class PrimeNumber {
    public static void main(String[] args) {
     int n=40;
     boolean[]primes=new boolean[n+1];
     sieveErathothenes(n,primes);
    }

    public int countPrimes(int n) {
        if(n<=2){
            return 0;
        }
        boolean[] prime=new boolean[n+1];
        for(int i=2;i*i<=n;i++){
            if(!prime[i]){
                for(int j=2*i;j<=n;j+=i){
                    prime[j]=true;
                }
            }
        }
        int count=0;
        for(int i=2;i<n;i++){
            if(!prime[i]){
                count++;
            }
        }
        return count;
    }
        static void sieveErathothenes(int n,boolean[]primes){

        //tc=o(n*log(log(n)))
            //sc=0(n)
        for (int i=2;i*i<=n;i++){
            if (!primes[i]){
                for (int j=i*2;j<=n;j+=i){
                    primes[j]=true;
                }
            }
        }
        for (int i=2;i<=    n;i++){
            if (!primes[i]){
                System.out.print(i+" ");
            }
        }

        }
    private static void primeNUmbers(int n) {
        for(int i=2;i<n;i++){
          if (isPrime(i)){
              System.out.print(i+" ");
          }
        }
    }
    static boolean isPrime(int n){
        int c=2;
        while (c*c<=n){
            if (n%c==0){
                return false;
            }
            c++;
        }
        return true;
    }

}
