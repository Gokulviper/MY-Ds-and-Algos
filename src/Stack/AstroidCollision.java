package Stack;

import java.util.Arrays;
import java.util.Stack;

class AstroidCollision {
    public static void main(String[] args) {
        int[]nums={5,10,-5};
        System.out.println(Arrays.toString(asteroidCollision(nums)));

    }
    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> s= new Stack<>();

        for(int i=0;i<asteroids.length;i++)
        {
            int ast= asteroids[i];

            // pushing only the positive asteroids
            if(ast>0)
            {
                s.push(ast);
            }
            else
            {
                while(!s.isEmpty() && s.peek()>0 && Math.abs(ast) > s.peek())
                {
                    s.pop();
                }

            /* Handling such cases:

            1.[2,4,-5] (Justifying the 1st condition of if statement)
                i) Here both the +ve asteroids 2,4 will be added into the stack first
                ii) Then inside the while loop both the +ve asteroids will be poped out.
                iii) Then it will see that the stack is empty so it will add the asteroid moving in -ve (-5)

            Output: [-5]

            2.[-5,-6,10] (Justifying the 2nd condition of if statement)
                i) Here after entering the else part the stack will be empty, so -5 will be added to stack
                ii) Then again it will enter the else part and then 2nd condition of if statement will  be true, i.e. s.peek() which -5 <0, so -6 will be added into the stack.
                iii) After that 10 will be pushed.

            Output:[-5,-6,10]
            */

                if(s.isEmpty() || s.peek()<0)
                {
                        s.push(ast);
                }

             /* Handling such cases:

            1.[10,5,-5,11] (Justifying the 1st condition of if statement)
                i) First the 2 +ve asteroids  (10,5) will be pushed.
                ii) Then it will enter the the last if condition.
                iii) The positive (5) will be poped out
                iv) 11 will be pushed after this.

            Output: [10,11]

            */

                if(s.peek()== Math.abs(ast))
                {
                    s.pop();
                }
            }

        }




        int res[] = new int[s.size()];
        int id=s.size()-1;
        while(!s.isEmpty())
        {
            res[id]= s.pop();
            id--;

        }

        return res;

    }
}