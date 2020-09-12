class Solution {
//https://leetcode.com/problems/reverse-integer
  public int reverse(int x) {

    boolean isNeg = false;
    if (x < 0) {
      isNeg = true;
      x = -x;
    }

    int reverse = 0,
    prevReverse = 0;

    while (x != 0) {

      int rem = x % 10;

      reverse = reverse * 10 + rem;

      //Handle overload// Check if (reverse - rem) / 10 equal to prevReverse
      if ((reverse - rem) / 10 != prevReverse) {
        return 0;
      }

      prevReverse = reverse;
      x = x / 10;
    }

    return isNeg ? -reverse: reverse;
  }
}
