class Solution {
    //Stack, Backtrack, DP
  //Video for ref: https://www.youtube.com/watch?v=s9fokUqJ76A
    public List<String> generateParenthesis(int n) {
        Stack<Character> stack=new Stack<>();
        List<String> result=new ArrayList<>();
        backtrack(result, stack, 0, 0, n);
        return result;
        
    }

    private void backtrack(List<String> result, Stack<Character> stack, int open, int closed, int n ){
        //Base end case
        if(open==closed && closed==n){
            Iterator itr=stack.iterator();
            StringBuilder sb=new StringBuilder();
            while(itr.hasNext()){
                sb.append(itr.next());
            }
            result.add(sb.toString());
            return;
        }

        if(open<n){
            stack.push('(');
            backtrack(result, stack, open+1, closed,n);
            stack.pop();
        }

        if(closed<open){
            stack.push(')');
            backtrack(result, stack, open, closed+1,n);
            stack.pop();

        }

    }
}
