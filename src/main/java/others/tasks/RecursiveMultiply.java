package others.tasks;

/**
 * Write a recursive function to multiply two positive integers without using the * operator.
 */
public class RecursiveMultiply {
  public static void main(String[] args) {
    int res = mult(5, 7);
    System.out.println(res);
  }

  private static int mult(int a, int b) {
    int smaller = Math.min(a, b);
    int bigger = Math.max(a, b);
    if (smaller == 1) {
      return bigger;
    }
    int half = mult(smaller >> 1, bigger);
    if (smaller % 2 == 0) {
      return half + half;
    } else {
      return half + half + bigger;
    }
  }
}
