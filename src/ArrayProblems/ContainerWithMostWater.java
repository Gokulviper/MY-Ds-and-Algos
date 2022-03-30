package ArrayProblems;

class ContainerWithMostWater {
    public static void main(String[] args) {

    }
    public static int maxArea(int[] height) {
        int max=0;
        int left=0,right= height.length-1;
        while (left<right){
            if (height[left]<height[right]){
                max=Math.max(max,height[left]*(right-left));
                left+=1;

            }else{
                max=Math.max(max,height[right]*(right-left));
                right-=1;
            }
        }
        return max;
    }
}