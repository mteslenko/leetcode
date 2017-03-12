package leetcode.tasks;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {
  public int eraseOverlapIntervals(Interval[] intervals) {
    if (intervals.length == 0) {
      return 0;
    }
    Arrays.sort(intervals, Comparator.comparingInt(i -> i.start));
    int taken = 0;
    int prev = 0;
    for (int i = 1; i < intervals.length; i++) {
      Interval interval0 = intervals[prev];
      Interval interval1 = intervals[i];
      if (interval1.end < interval0.end) {
        prev = i;
        taken++;
      } else if (interval1.start < interval0.end) {
        taken++;
      } else {
        prev = i;
      }
    }
    return taken;
  }

  public int eraseOverlapIntervals_dp(Interval[] intervals) {
    if (intervals.length == 0) {
      return 0;
    }
    Arrays.sort(intervals, Comparator.comparingInt(i -> i.start));
    int[] dp = new int[intervals.length];
    dp[0] = 1;
    for (int i = 0; i < intervals.length - 1; i++) {
      dp[i + 1] = maxNotOverlapping(intervals, dp, i + 1) + 1;
    }
    return intervals.length - dp[intervals.length - 1];
  }

  private int maxNotOverlapping(Interval[] intervals, int[] dp, int i) {
    int maxNotOverlapping = 0;
    for (int j = i - 1; j >= 0; j--) {
      if (!isOverlapping(intervals[j], intervals[i])) {
        maxNotOverlapping = Math.max(maxNotOverlapping, dp[j]);
      }
    }
    return maxNotOverlapping;
  }

  public int eraseOverlapIntervals_bruteForce(Interval[] intervals) {
    Arrays.sort(intervals, Comparator.comparingInt(i -> i.start));
    return eraseOverlapIntervals_bruteForce(-1, 0, intervals);
  }

  private int eraseOverlapIntervals_bruteForce(int prev, int curr, Interval[] intervals) {
    if (curr >= intervals.length) {
      return 0;
    }
    int taken = -1;
    if (prev == -1 || !isOverlapping(intervals[prev], intervals[curr])) {
      taken = eraseOverlapIntervals_bruteForce(curr, curr + 1, intervals);
    }
    int notTaken = eraseOverlapIntervals_bruteForce(prev, curr + 1, intervals) + 1;
    if (taken >= 0) {
      return Math.min(taken, notTaken);
    } else {
      return notTaken;
    }
  }

  private boolean isOverlapping(Interval prevInterval, Interval currInterval) {
    return prevInterval.end > currInterval.start;
  }
}
