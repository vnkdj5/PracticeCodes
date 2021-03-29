class Solution {
    
     public static int romanToInt(String s) {
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
