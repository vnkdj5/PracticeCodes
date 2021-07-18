import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

class Solution {
    class CustomOrderComparator implements Comparator<Character> {
        Map<Character, Integer> orderMap;
        int max=0;

        public CustomOrderComparator(String order){
            orderMap=new HashMap<>();
            for(int i=0;i<order.length();i++){
                orderMap.put(order.charAt(i), i+1);
                
            }
            max=order.length()+1;
        }

        public int compare(Character a, Character b){
            int val1=orderMap.getOrDefault(a, max);
            int val2=orderMap.getOrDefault(b, max);
            return val1-val2;
        }

      
    }
    public String customSortString(String order, String str) {
        if(str==null||order==null)
            return str;
        
        CustomOrderComparator comparator=new CustomOrderComparator(order);

        Character strArr[]=str.chars().
                mapToObj(c -> (char)c).
                toArray(Character[]::new);
        Arrays.sort(strArr, comparator);

        StringBuilder builder = new StringBuilder();
        for(Character ch: strArr)
            builder.append(ch);
        return builder.toString();


    }
}
