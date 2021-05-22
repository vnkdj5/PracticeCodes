import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
  //2 pointers apptoch
  public List < List < Integer >> threeSum(int[] a) {
    Arrays.sort(a);
    List < List < Integer >> list = new ArrayList < > ();

    for (int i = 0; i < a.length - 2; i++) {

      if (i > 0 && a[i] == a[i - 1]) //Skip the same result as its already computed using below 2 pointer
        continue;
      //a+b+c=0
      // therefore b+c=-a
      int target = -a[i];

      int j = i + 1, k = a.length - 1;

      while (j < k) {
        if (target == a[j] + a[k]) {
          list.add(Arrays.asList(a[i], a[j], a[k]));
          j++;
          k--;
          //Optimizations
          while (j < k && a[j] == a[j - 1]) j++; //Skip the sam result
          while (j < k && a[k] == a[k + 1]) k--; //Skip the same result
        } else if (target < a[j] + a[k]) {
          k--;
        } else {
          j++;
        }
      }
    }
    return list;
  }

  public List < List < Integer >> threeSum_1(int[] a) {
    Arrays.sort(a);
    Set < List < Integer >> set = new HashSet < > ();

    for (int i = 0; i < a.length - 2; i++) {
      //a+b+c=0
      // therefore b+c=-a
      int target = -a[i];

      int j = i + 1, k = a.length - 1;

      while (j < k) {
        if (target == a[j] + a[k]) {
          set.add(Arrays.asList(a[i], a[j], a[k]));
          j++;
          k--;
        } else if (target < a[j] + a[k]) {
          k--;
        } else {
          j++;
        }
      }
    }
    return new ArrayList(set);
  }

  public List < List < Integer >> threeSum_0(int[] a) {
    Map < Integer, Integer > map = new HashMap < > ();
    Arrays.sort(a);
    for (int i = 0; i < a.length; i++) {
      map.put(a[i], i);
    }
    Set < List < Integer >> ts = new HashSet();
    for (int i = 0; i < a.length - 1; i++) {
      // a+b+c=0
      // therefore c=0-a-b;
      int first = a[i];
      for (int j = i + 1; j < a.length; j++) {
        int third = 0 - first - a[j];
        if (map.containsKey(third) && map.get(third) > j) {
          List < Integer > list = new ArrayList < > ();
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
