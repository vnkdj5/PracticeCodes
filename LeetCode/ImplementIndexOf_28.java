class Solution {
    public int strStr(String heystack, String needle) {
           if(needle.isEmpty())
            return 0;
        
        if(heystack==null || heystack.isEmpty()){
            return -1;
        }
     
        for(int i=0; i<heystack.length();i++){
            if((i+needle.length())>heystack.length())
                break;
            
                int j=0;
                while(j<needle.length()){
                    if(needle.charAt(j)==heystack.charAt(i+j))
                        j++;
                    else
                        break;
                }
                if(j==needle.length())
                    return i;
            
        }
        return -1;
    }
}
