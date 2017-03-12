package others.tasks;

import java.util.stream.IntStream;

public class LIS {
  public static void main(String[] args) {
    int l = lengthOfLIS(new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6});
    System.out.println(l);
  }

  public static int lengthOfLIS(int[] nums) {
    int[] dp = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      int maxSub = 0;
      for (int j = 0; j < i; j++) {
        if (nums[j] < nums[i]) {
          maxSub = Math.max(maxSub, dp[j]);
        }
      }
      dp[i] = maxSub + 1;
    }
    return IntStream.of(dp).max().orElse(0);
  }
}
