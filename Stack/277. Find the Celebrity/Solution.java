/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        Stack<Integer> stack = new Stack<>();
        int celebrity = -1;
        //push all people in stack
        for (int i = 0; i < n; i++) {
            stack.push(i);
        }
        
        while (!stack.isEmpty()) {
            //take two people out of stack and check if they know each other
            //one who doesn't know the other, push it back in stack
            int x = stack.pop();
            if (stack.isEmpty()) {
                celebrity = x;
                break;
            }
            
            int y = stack.pop();
            if (knows(x,y)) {
                stack.push(y);
            } else {
                stack.push(x);
            }
        } // end of while loop
        // at this point we will only have last element of stack as celebrity
        //check it to make sure it's the right celebrity
        for (int j=0; j<n;j++) {
            if (celebrity != j && (knows(celebrity,j) || !(knows(j,celebrity)))) {
                return -1;
            }
        }
        return celebrity;
    }
}
