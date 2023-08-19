class Solution {
     final char[][] L = {{},{},{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},
	{'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};
    



/*

    Time Complexity : O(3^N × 4^M) where N is the number of digits which have 3 letters( ex: 2,3,4) assigned to
    it and M is the number of digits which has 4 letters(ex: 7,9) assigned to it.

    Space Complexity : O(3^N × 4^M) where N is the number of digits which have 3 letters( ex: 2,3,4) assigned to
    it and M is the number of digits which has 4 letters(ex: 7,9) assigned to it.

    Solved using String + Backtracking + Hash Table. Recursive Approach.

*/
    public List<String> letterCombinations_DFS(String digits) {
        int len=digits.length();
        List<String> ans=new ArrayList<>();
        if(len==0) return ans;
        dfs(0, len, new StringBuilder(), ans, digits);
        return ans;
    }

    private void dfs(int pos, int len, StringBuilder sb, List<String> ans, String digits){
        if(len==pos)//Reached to the end of the tree(leaf nodes)
            ans.add(sb.toString());
        else{
            char []letters=L[Character.getNumericValue(digits.charAt(pos))];

            for(int i=0;i<letters.length;i++){
                dfs(pos+1, len, new StringBuilder(sb).append(letters[i]), ans, digits);
            }
        }
    }

/*

    Time Complexity : O(3^N × 4^M) where N is the number of digits which have 3 letters( ex: 2,3,4) assigned to
    it and M is the number of digits which has 4 letters(ex: 7,9) assigned to it.

    Space Complexity : O(3^N × 4^M) where N is the number of digits which have 3 letters( ex: 2,3,4) assigned to
    it and M is the number of digits which has 4 letters(ex: 7,9) assigned to it.

    Solved using String + Hash Table. Iterative Approach.

*/
//BFS
    public List<String> letterCombinations(String digits) {
        int len=digits.length();
        LinkedList<String> ans=new LinkedList<>();
        if(len==0) return ans;
        
        ans.add("");

        for(int i=0;i<len;i++){
            char[] letters=L[Character.getNumericValue(digits.charAt(i))];

            while(ans.peek().length()==i){ //BFS go by layer layer, size of 0,1,2,etc
                String preString=ans.remove();
                for(char current:letters){
                    ans.add(preString+current);
                }
            }
        }
        return ans;

    }
}
