class Solution {

	private static Map<Character, Integer> mappings = new HashMap<>();
static {
        mappings.put('I', 1);
        mappings.put('V', 5);
        mappings.put('X', 10);
        mappings.put('L', 50);
        mappings.put('C', 100);
        mappings.put('D', 500);
        mappings.put('M', 1000);
    }


public int romanToInt(String s) {

    int result = 0;
    int prevValue = 0;

    /*
This code iterates through the string in reverse and accumulates the result based on the current and previous Roman numeral values. If the current value is smaller than the previous one, it subtracts the current value; otherwise, it adds the current value. This approach simplifies the conditional logic and eliminates the need for multiple subtraction checks.

    */

    for(int i=s.length()-1; i>=0;i--){
        int current=mappings.get(s.charAt(i));
        if(current<prevValue){
            result=result-current;
        }else{
            result=result+current;
        }
        prevValue=current;
    }

    return result;

}

   
    public int romanToIntV1(String s) {
         Map<Character, Integer> mappings = new HashMap<Character, Integer>()
{{
     put('I', 1);
     put('V', 5);
     put('X', 10);
     put('L', 50);
     put('C', 100);
     put('D', 500);
     put('M', 1000);
}};
        char prev=' ';
        int len=s.length();
        int ans=0;

        /*
        Logic: If cases handle common scnearios of substraction.
        Also, we can start from the end also to reduce the cases.

        */
        for(int i=0;i<len;i++){
            char current=s.charAt(i);
            if(prev=='I' && (current=='V' || current=='X')){
                ans+=(mappings.get(current)-mappings.get('I')*2);
            }else if(prev=='X' && (current=='L' || current=='C')){
                ans+=(mappings.get(current)-mappings.get('X')*2);
            }else if(prev=='C' && (current=='D' || current=='M')){
                ans+=(mappings.get(current)-mappings.get('C')*2);
            }else{
                ans+=mappings.get(current);
            }
            prev=current;
        }

        return ans;
        
    }
    
     public static int romanToIntV2(String s) {
    if (s == null || s.length() == 0)
		return -1;
	HashMap<Character, Integer> map = new HashMap<Character, Integer>();
	map.put('I', 1);
	map.put('V', 5);
	map.put('X', 10);
	map.put('L', 50);
	map.put('C', 100);
	map.put('D', 500);
	map.put('M', 1000);
	int len = s.length(), result = map.get(s.charAt(len - 1));
         
    for(int i=len-2; i>=0;i--){
        if(map.get(s.charAt(i))>=map.get(s.charAt(i+1)))
            result+=map.get(s.charAt(i));
        else
            result-=map.get(s.charAt(i));
    }
         
    return result;
     }
    
    
    
    
    public int romanToInt1(String s) {
        char prev = ' ';
        int num = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            switch (ch) {
                case 'I':
                    if (prev == 'V' || prev == 'X')
                        num -= 1;
                    else
                        num += 1;
                    break;
                case 'V':
                    num += 5;
                    break;
                case 'X':
                    if (prev == 'L' || prev == 'C')
                        num -= 10;
                    else
                        num += 10;
                    break;
                case 'L':
                    num += 50;
                    break;
                case 'C':
                    if (prev == 'D' || prev == 'M')
                        num -= 100;
                    else
                        num += 100;
                    break;
                case 'D':
                    num += 500;
                    break;
                case 'M':
                    num += 1000;
                    break;
            }
            prev = ch;
        }
        return num;
    }
}
