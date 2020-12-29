class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        //iterate through the string
        for (int i=0; i <s.length(); i++) {
            char item = s.charAt(i);
            //for every closing parentheses: 
            //if no matched opening parentheses in stack, return false
            //pop the stack,if it is not match, return false
            if (item == ')' || item == '}' || item == ']') {
                if (stack.isEmpty()) return false;
                if (item == ')' && stack.pop() != '(' || 
                   item == '}' && stack.pop() != '{' ||
                   item == ']' && stack.pop() != '[') {
                    return false;
                }
            }
            //put each opening parentheses into stack
            else {
                stack.push(item);
            }
        }
        //return false if any opening parentheses left in the stack if iteration is end
        if (!stack.isEmpty()) return false;
        return true;   
    }
}
