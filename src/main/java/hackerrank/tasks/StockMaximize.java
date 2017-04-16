package hackerrank.tasks;

import java.util.Scanner;

public class StockMaximize {

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int t = in.nextInt();
      for (int a0 = 0; a0 < t; a0++) {
        int numOfDays = in.nextInt();
        int[] prices = new int[numOfDays];
        for (int pricesI = 0; pricesI < numOfDays; pricesI++) {
          prices[pricesI] = in.nextInt();
        }
        long sum = 0;
        int start = 0;
        while (start < numOfDays) {
          int max = start;
          for (int i = start + 1; i < numOfDays; i++) {
            if (prices[i] > prices[max]) {
              max = i;
            }
          }
          long subSum = 0;
          for (int i = start; i < max; i++) {
            subSum += prices[i];
          }
          if (subSum > 0) {
            sum += prices[max] * (long) (max - start) - subSum;
          }
          start = max + 1;
        }
        System.out.println(sum);
      }
    }
  }
}
