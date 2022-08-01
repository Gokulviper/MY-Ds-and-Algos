package Stack.MonotonicstackProblems;


import java.util.Arrays;
import java.util.Stack;

public class DailyTempratures {
    public static void main(String[] args) {
int[]nums={73,74,75,71,69,72,76,73};
        Arrays.toString(dailyTemperatures(nums));
    }
    public static int[] dailyTemperatures(int[] nums) {
        int n=nums.length;
        int[] ans=new int[n];
        Stack<Integer>stack=new Stack<>();
        for (int i=0;i<n;i++){
            while (!stack.isEmpty()&&nums[stack.peek()]<nums[i] ){
                int prev=stack.pop();
                ans[i]=i-prev;
            }
            stack.push(i);
        }
        return ans;

    }
    public int[] dailyTemperaturesspace(int[] temperatures) {
        int n = temperatures.length;
        int hottest = 0;
        int answer[] = new int[n];

        for (int currDay = n - 1; currDay >= 0; currDay--) {
            int currentTemp = temperatures[currDay];
            if (currentTemp >= hottest) {
                hottest = currentTemp;
                continue;
            }

            int days = 1;
            while (temperatures[currDay + days] <= currentTemp) {
                // Use information from answer to search for the next warmer day
                days += answer[currDay + days];
            }
            answer[currDay] = days;
        }

        return answer;
    }
}
