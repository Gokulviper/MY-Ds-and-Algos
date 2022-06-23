package BitManipulations.Problems;
//amazon interview
public class CountTotalSetBits {
    public static void main(String[] args) {
        System.out.println(counttBits(7));
    }

    private static int counttBits(int n) {
        //tc=n(log(n))
        int count=0;
        for (int j = 1; j <=n ; j++) {
            count+=counttBitsUtil(j);
        }
        return count;
    }

    private static int counttBitsUtil(int n) {
        int count=0;
        while (n>0){
            if ((n&1)==1)count++;
            n>>=1;

        }
        return count;
    }
    /*
    Approach:

For each number ‘n’, there will be a number a, where a<=n and a is perfect power of two, like 1,2,4,8…..

Let n = 11, now we can see that

Numbers till n, are:
0  -> 0000000
1  -> 0000001
2  -> 0000010
3  -> 0000011
4  -> 0000100
5  -> 0000101
6  -> 0000110
7  -> 0000111
8  -> 0001000
9  -> 0001001
10 -> 0001010
11 -> 0001011

Now we can see that, from 0 to pow(2,1)-1 = 1, we can pair elements top-most with bottom-most,
and count of set bit in a pair is 1

Similarly for pow(2,2)-1 = 4, pairs are:
00 and 11
01 and 10
here count of set bit in a pair is 2, so in both pairs is 4

Similarly we can see for 7, 15, ans soon.....

so we can generalise that,
count(x) = (x*pow(2,(x-1))),
here x is position of set bit of the largest power of 2 till n
for n = 8, x = 3
for n = 4, x = 2
for n = 5, x = 2

so now for n = 11,
we have added set bits count from 0 to 7 using count(x) = (x*pow(2,(x-1)))

for rest numbers 8 to 11, all will have a set bit at 3rd index, so we can add
count of rest numbers to our ans,
which can be calculated using 11 - 8 + 1 = (n-pow(2,x) + 1)

Now if notice that, after removing front bits from rest numbers, we get again number from 0 to some m
so we can recursively call our same function for next set of numbers,
by calling countSetBits(n - pow(2,x))
8  -> 1000  -> 000 -> 0
9  -> 1001  -> 001 -> 1
10 -> 1010  -> 010 -> 2
11 -> 1011  -> 011 -> 3
     */
    static int findLargestPower(int n)
    {
        int x = 0;
        while ((1 << x) <= n)
            x++;
        return x - 1;
    }

    static int countSetBits(int n)
    {
        //tc=log(n)
        if (n <= 1)
            return n;
        int x = findLargestPower(n);
        return (x * (int)Math.pow(2, (x - 1))) + (n - (int)Math.pow(2, x) + 1)
                + countSetBits(n - (int)Math.pow(2, x));
    }

}
