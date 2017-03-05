package leetcode.tasks;

import java.util.Stack;

/**
 * @see <a href="https://leetcode.com/problems/largest-rectangle-in-histogram">Leetcode</a>
 */
public class LargestRectangleInHistogram {
  public int largestRectangleArea(int[] heights) {
    Stack<Integer> stack = new Stack<>();
    int maxArea = 0;
    for (int i = 0; i < heights.length; i++) {
      if (stack.isEmpty() || heights[i] > heights[stack.peek()]) {
        stack.push(i);
      } else {
        while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
          Integer top = stack.pop();
          if (stack.isEmpty()) {
            maxArea = Math.max(maxArea, heights[top] * i);
          } else {
            maxArea = Math.max(maxArea, heights[top] * (i - (stack.peek() + 1)));
          }
        }
        stack.push(i);
      }
    }
    while (!stack.isEmpty()) {
      Integer top = stack.pop();
      if (stack.isEmpty()) {
        maxArea = Math.max(maxArea, heights[top] * heights.length);
      } else {
        maxArea = Math.max(maxArea, heights[top] * (heights.length - (stack.peek() + 1)));
      }
    }
    return maxArea;
  }
}
