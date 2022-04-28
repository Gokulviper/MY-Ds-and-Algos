package ArrayProblems;

class KthElementOf2Arrays {
    public static void main(String[] args) {
        int[]num1={1,4,6,8,90},num2={5,7,11,33};
        System.out.println(kthElement(num1,num2, num1.length, num2.length, 7));
    }
    public static long kthElement( int nums1[], int nums2[], int n, int m, int k) {
        int i=0,j=0,num=0;
        while (i< nums1.length&&j< nums2.length){

                if (nums1[i]<nums2[j]){
                    num=nums1[i];
                    i++;
                    k--;
                }


                else if (nums1[i]>nums2[j]){
                    num=nums2[j];
                    j++;
                    k--;
                }
                if (k==0){
                    break;
                }
            }
        if (k>0){
            while (i<nums1.length&&k>0){
                num=nums1[i];
                i++;
                k--;
            }
            while (j<nums2.length&&k>0){
                num=nums2[j];
                j++;
                k--;
            }
        }
        return num;
        }
        
    }