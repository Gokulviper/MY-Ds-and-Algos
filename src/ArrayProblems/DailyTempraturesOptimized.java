package ArrayProblems;

import java.util.Arrays;

class DailyTempraturesOptimized {
    public static void main(String[] args) {

        int[]nums={73,74,75,71,69,72,76,73};
        System.out.println(Arrays.toString(dailyTemperatures(nums)));

    }
    public static int[] dailyTemperatures1(int[] nums) {
        int n=nums.length;
        int[]ans=new int[n];
        int hottest=0;
        for (int i=nums.length-1;i>=0;i--){
            int current_temp=nums[i];
            if (current_temp>=hottest){
                hottest=current_temp;
                continue;
            }
            int days=1;
            while (nums[i+days]<=current_temp){
                days+=ans[i+days];
            }
            ans[i]=days;
        }
        return ans;
    }
    public static int[] dailyTemperatures(int[] nums) {
        int n = nums.length;
        int hottest = 0;
        int answer[] = new int[n];
        
        for (int i = n - 1; i >= 0; i--) {
            int currentTemp = nums[i];
            if (currentTemp >= hottest) {
                hottest = currentTemp;
                continue;
            }
            
            int days = 1;
            while (nums[i + days] <= currentTemp) {
                // Use information from answer to search for the next warmer day
                days += answer[i + days];
            }
            answer[i] = days;
        }
        
        return answer;
    }
}