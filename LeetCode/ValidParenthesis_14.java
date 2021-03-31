import java.util.*;

class Solution {
    private HashMap<Character, Character> mappings;
    
    public Solution(){
        mappings=new HashMap<>();
        mappings.put(')','(');
        mappings.put(']','[');
        mappings.put('}','{');
    }
    public boolean isValid(String s){
        if(s==null || s.isEmpty())
            return true;
        Stack<Character> stack = new Stack<>();
        
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            //closing brackets case
            if(mappings.containsKey(ch)){
                if(stack.empty() || mappings.get(ch)!=stack.pop())
                    return false;
            }else //Opening brckets case
                stack.push(ch);
        }
        
        return stack.isEmpty();
    }
    
    public boolean isValid_1(String s) {
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
