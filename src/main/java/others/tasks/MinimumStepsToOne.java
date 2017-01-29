package others.tasks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * On a positive integer, you can perform any one of the following 3 steps.
 * 1.) Subtract 1 from it. ( n = n - 1 )
 * 2.) If its divisible by 2, divide by 2. ( if n % 2 == 0 , then n = n / 2  )
 * 3.) If its divisible by 3, divide by 3. ( if n % 3 == 0 , then n = n / 3  ).
 * <p>
 * Now the question is, given a positive integer n, find the minimum number of steps that
 * takes n to 1
 * <p>
 * eg:
 * 1.) For n = 1 , output: 0
 * 2.) For n = 4 , output: 2  ( 4  /2 = 2  /2 = 1 )
 * 3.) For n = 7 , output: 3  (  7  -1 = 6   /3 = 2   /2 = 1 )
 */
class MinimumStepsToOne {
  private Map<Integer, Result> minSteps = new HashMap<>();
  private Integer minFound;

  int doMemoization(int n) {
    return execute(n, this::memoization);
  }

  int doRecursion(int n) {
    return execute(n, (number) -> recursion(number, 0));
  }

  int doBottomUp(int n) {
    return execute(n, this::bottomUp);
  }

  private int execute(int n, Function<Integer, Result> func) {
    Result result = func.apply(n);
//    Collections.reverse(result.actions);
//    System.out.println(result.actions);
    return result.steps;
  }

  private Result bottomUp(int n) {
    minSteps.put(1, new Result(0, "=1"));
    for (int i = 2; i <= n; i++) {
      Result r3 = null;
      if (i % 3 == 0) {
        r3 = addAction(minSteps.get(i / 3), String.format("/3 = %d", i / 3));
      }
      Result r2 = null;
      if (i % 2 == 0) {
        r2 = addAction(minSteps.get(i / 2), String.format("/2 = %d", i / 2));
      }
      Result r1 = addAction(minSteps.get(i - 1), String.format("-1 = %d", i - 1));
      Result min = getMinResult(r3, r2, r1);
      minSteps.put(i, min);
    }
    return minSteps.get(n);
  }

  private Result memoization(int n) {
    Result computed = minSteps.get(n);
    if (computed != null) {
      return computed;
    }
    if (n == 1) {
      Result result = new Result(0, "=1");
      minSteps.put(1, result);
      return result;
    }
    Result r3 = null;
    if (n % 3 == 0) {
      r3 = addAction(memoization(n / 3), String.format("/3 = %d", n / 3));
    }
    Result r2 = null;
    if (n % 2 == 0) {
      r2 = addAction(memoization(n / 2), String.format("/2 = %d", n / 2));
    }
    Result r1 = addAction(memoization(n - 1), String.format("-1 = %d", n - 1));
    Result min = getMinResult(r3, r2, r1);
    minSteps.put(n, min);
    return min;
  }

  private Result recursion(int n, int currentStep) {
    if (minFound != null && currentStep >= minFound) {
      return null;
    }

    if (n == 1) {
      Result result = new Result(0, "=1");
      if (minFound == null || minFound > currentStep) {
        minFound = currentStep;
      }
      return result;
    }
    Result r3 = null;
    if (n % 3 == 0) {
      r3 = addAction(recursion(n / 3, currentStep + 1), String.format("/3 = %d", n / 3));
    }
    Result r2 = null;
    if (n % 2 == 0) {
      r2 = addAction(recursion(n / 2, currentStep + 1), String.format("/2 = %d", n / 2));
    }
    Result r1 = addAction(recursion(n - 1, currentStep + 1), String.format("-1 = %d", n - 1));
    return getMinResult(r3, r2, r1);
  }

  private Result getMinResult(Result r3, Result r2, Result r1) {
    if (r1 != null) {
      if (r3 != null) {
        if (r2 != null) {
          if (r1.steps < r2.steps && r1.steps < r3.steps) {
            return r1;
          } else {
            return r2.steps < r3.steps ? r2 : r3;
          }
        } else {
          return r1.steps < r3.steps ? r1 : r3;
        }
      } else {
        if (r2 != null) {
          return r1.steps < r2.steps ? r1 : r2;
        } else {
          return r1;
        }
      }
    } else {
      if (r3 != null) {
        if (r2 != null) {
          return r2.steps < r3.steps ? r2 : r3;
        } else {
          return r3;
        }
      } else {
        return r2 != null ? r2 : null;
      }
    }
  }


  private Result addAction(Result r, String action) {
    if (r != null) {
      Result result = new Result(r);
      result.steps = r.steps + 1;
      result.actions.add(action);
      return result;
    } else {
      return null;
    }
  }

  private static class Result {
    private int steps;
    private List<String> actions = new ArrayList<>();


    Result(int steps, String action) {
      this.steps = steps;
      actions = new ArrayList<>();
      actions.add(action);
    }

    Result(Result r) {
      steps = r.steps;
      actions = new ArrayList<>(r.actions);
    }

    @Override
    public String toString() {
      return "Result{" + "steps=" + steps + ", actions=" + actions + '}';
    }
  }
}
