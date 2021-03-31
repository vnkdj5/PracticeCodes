import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        if(s==null || s.isEmpty())
            return true;

        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length();i++){
            char ch = s.charAt(i);
            switch (ch){
                case '(':
                case '[':
                case '{':
                    stack.push(ch);
                    break;
                case ')':
                    if(stack.empty() || !(stack.pop() =='('))
                        return false;
                    break;
                case ']':
                    if(stack.empty() || !(stack.pop() =='['))
                        return false;
                    break;
                case '}':
                    if(stack.empty() || !(stack.pop() =='{'))
                        return false;
                    break;
            }
        }
       return stack.isEmpty();
    }
}
