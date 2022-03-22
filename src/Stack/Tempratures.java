package Stack;

import java.util.Arrays;
import java.util.Stack;

class Tempratures {
    public static void main(String[] args) {
int nums[]={89,62,70,58,47,47,46,76,100,70};
//Output
//[8,1,5,4,2,2,1,1,0,0]
//Expected
//[8,1,5,4,3,2,1,1,0,0]
//  int ans[]=dailyTemperatures(nums);
        System.out.println(Arrays.toString(dailyTemperatures(nums)));

    }
    public static int[] dailyTemperatures(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        Stack<Integer> stack=new Stack();

        for (int i = 0; i < n; i++) {
            int currentTemp = nums[i];
            // Pop until the current day's temperature is not
            // warmer than the temperature at the top of the stack
            while (!stack.isEmpty() && nums[stack.peek()] < currentTemp) {
                int prevDayIndex = stack.pop();
                answer[prevDayIndex] = i - prevDayIndex;
            }
            stack.push(i);
        }

        return answer;
    }
    public static int[] dailyTemperatures1(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[j] > nums[i]) {
                    answer[i] = j - i;
                    break;
                }
            }
        }

        return answer;
    }

}