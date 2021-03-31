class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        String smallest = strs[0];

        for(int i=1; i<strs.length; i++){
            while (strs[i].indexOf(smallest)!=0){
                smallest=smallest.substring(0, smallest.length()-1);
                if(smallest.isEmpty())
                    return "";
            }
        }

        return smallest;
    }
}
