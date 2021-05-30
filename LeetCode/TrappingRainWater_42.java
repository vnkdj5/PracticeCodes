class Solution {

  //2 pointers approch
  public int trap(int[] height) {
    if (height == null || height.length == 0)
      return 0;
    int ans = 0;
    int leftMax = 0, rightMax = 0;
    int left = 0, right = height.length - 1;
    while (left < right) {
      if (height[left] > leftMax)
        leftMax = height[left];
      if (height[right] > rightMax)
        rightMax = height[right];
      if (leftMax < rightMax) {
        ans += leftMax - height[left];
        left++;
      } else {
        ans += rightMax - height[right];
        right--;
      }

    }
    return ans;

  }

  //Dymanic Programming solution    
  public int trap2(int[] height) {
    if (height == null || height.length == 0)
      return 0;
    int ans = 0;
    int size = height.length;
    int[] leftMax = new int[size];
    int[] rightMax = new int[size];

    leftMax[0] = height[0];
    for (int i = 1; i < size; i++) {
      leftMax[i] = Math.max(height[i], leftMax[i - 1]);
    }

    rightMax[size - 1] = height[size - 1];
    for (int i = size - 2; i >= 0; i--) {
      rightMax[i] = Math.max(height[i], rightMax[i + 1]);
    }

    for (int i = 0; i < size; i++) {
      ans += Math.min(leftMax[i], rightMax[i]) - height[i];
    }

    return ans;
  }

  //Brute force  
  public int trap1(int[] height) {
    int ans = 0;
    for (int i = 0; i < height.length; i++) {
      int left_max = 0, right_max = 0;
      for (int j = i; j >= 0; j--)
        left_max = Math.max(left_max, height[j]);

      for (int j = i; j < height.length; j++)
        right_max = Math.max(right_max, height[j]);

      ans += Math.min(left_max, right_max) - height[i];

      System.out.println("MIN(" + left_max + " , " + right_max + ")-  " + height[i] + "=" + ans);
    }

    return ans;
  }
}
