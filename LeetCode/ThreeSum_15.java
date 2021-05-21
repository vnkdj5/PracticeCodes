import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
  
  //Hashmap O(n^2)solution using 2 sum problem approch modified
    public List<List<Integer>> threeSum(int[] a) {
         Map<Integer, Integer> map = new HashMap<>();
         Arrays.sort(a);
        for (int i = 0; i < a.length; i++) {
            map.put(a[i], i);
        }
        Set<List<Integer>> ts = new HashSet();
        for(int i=0;i<a.length;i++){
           // a+b+c=0
          // therefore c=0-a-b;
            int first =  a[i];
            for(int j=i+1;j<a.length;j++){
                int third=0-first-a[j];
                if(map.containsKey(third) && map.get(third)>j){
                    List<Integer> list = new ArrayList<>();
                    list.add(first);
                    list.add(a[j]);
                    list.add(third);
                    ts.add(list);
                }

            }
        }
         return new ArrayList(ts);
    }
}
