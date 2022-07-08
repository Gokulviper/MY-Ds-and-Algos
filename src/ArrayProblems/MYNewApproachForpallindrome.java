package ArrayProblems;

public class MYNewApproachForpallindrome {
    public static void main(String[] args) {
        System.out.println(3^0);
        int[]nums={9,8,7,1,7,8,9};
        int sum=0;
        for (int num:nums){
            sum^=num;
        }
        System.out.println(sum);
        if (nums.length%2==0){
            if(sum==0){
                System.out.println("pallindrome");
            }else{
                System.out.println("not pallindrome");
            }
        }else{
            int mid =(nums.length)/2;
            if (nums[mid]==sum){
                System.out.println("pallindrome");
            }else{
                System.out.println("not pallindrome");
            }
        }
    }
}
