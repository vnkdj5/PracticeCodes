class Solution {
    public String reverseWords(String s) {
        char str[]=s.toCharArray();
        int i=0,j=0;
        
        while(j<s.length()){
             
            //For finding last index+1 of word
            while(j<s.length() && str[j]!=' '){
                j++;
            }
            //Reverse the word
            reverse(str,i, j-1);
            
            //Update pointers Both will point to next letter after space.
            j++;
            i=j;
            
        }
        return new String(str);
        
    }
    
    /*
    Reverse the characters in str array from ith index to jth index(Both included)
    */
    private void reverse(char[] str, int i,int j){
        while(i<j){
            char temp=str[i];
            str[i]=str[j];
            str[j]=temp;
            i++;
            j--;
        }
    }
}
