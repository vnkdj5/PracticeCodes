class Solution {
    public String convert(String s, int numRows) {
        
        //Base case
        if(s.length()<=numRows|| numRows==1)
            return s;
        
        StringBuffer sb[]=new StringBuffer[numRows];
        for(int i=0;i<numRows;i++)
            sb[i]=new StringBuffer();
        
        //Store each row differently and at last combine rows
        //Direction will be used to change the rowIndx when it reacher low/high
        int direction=-1;
        int rowIndex=0;
        for(int i=0;i<s.length();i++){
            sb[rowIndex].append(s.charAt(i));
            
            if(rowIndex==0 || rowIndex==numRows-1)
                direction*=-1;
            
            rowIndex+=direction;            
        }
        
        //Combine resultant rows sb
        for(int i=1;i<numRows;i++)
            sb[0].append(sb[i]);
        
        //return ans
        return sb[0].toString();
        
    }
    
    public String convert1(String s, int numRows) {
        
        //Base case
        int len=s.length();
        if(len<=numRows|| numRows==1)
            return s;
        
        int interval=2*numRows-2;
        StringBuffer result=new StringBuffer();
        for(int i=0;i<numRows;i++){
            for(int j=i;j<len;j+=interval){
                result.append(s.charAt(j));
                int k=j+interval-2*i; //Middle rows
                if(i!=0 && i!=numRows-1 && k<len)
                    result.append(s.charAt(k));
            }
        }
        return result.toString();
        
        
    }
    
}
