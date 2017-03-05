package leetcode.tasks;

import java.util.Stack;

public class MaximalRectangle {
  public int maximalRectangle(char[][] matrix) {
    if (matrix.length == 0) {
      return 0;
    }
    int maxArea = 0;
    int[] rectangles = new int[matrix[0].length];
    for (char[] chars : matrix) {
      fillRectangles(rectangles, chars);
      maxArea = Math.max(maxArea, getRectanglesMaxArea(rectangles));
    }
    return maxArea;
  }

  private int getRectanglesMaxArea(int[] rectangles) {
    int maxArea = 0;
    int i = 0;
    Stack<Integer> stack = new Stack<>();
    while (i < rectangles.length) {
      if (stack.isEmpty() || rectangles[stack.peek()] < rectangles[i]) {
        stack.push(i++);
      } else {
        Integer top = stack.pop();
        maxArea =
            Math.max(maxArea, rectangles[top] * (stack.isEmpty() ? i : i - (stack.peek() + 1)));
      }
    }
    while (!stack.isEmpty()) {
      Integer top = stack.pop();
      maxArea = Math.max(maxArea, rectangles[top] * (stack.isEmpty() ? i : i - (stack.peek() + 1)));
    }
    return maxArea;
  }

  private void fillRectangles(int[] rectangles, char[] chars) {
    for (int i = 0; i < chars.length; i++) {
      char aChar = chars[i];
      if (aChar == '0') {
        rectangles[i] = 0;
      } else {
        rectangles[i]++;
      }
    }
  }
}
