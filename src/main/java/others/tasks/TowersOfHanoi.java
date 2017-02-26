package others.tasks;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * Solve Towers of Hanoi.
 */
public class TowersOfHanoi {

  public static final int N = 5;

  public static void main(String[] args) {
    List<List<Stack<Integer>>> initPath = new ArrayList<>();
    initPath.add(initTowers());
    List<List<Stack<Integer>>> path = hanoiRecursion(initPath);
    printPath(path);
  }

  private static List<Stack<Integer>> initTowers() {
    List<Stack<Integer>> towers = Arrays.asList(new Stack<Integer>(),
        new Stack<Integer>(),
        new Stack<Integer>());
    for (int i = N; i > 0; i--) {
      towers.get(0).push(i);
    }
    return towers;
  }

  private static void printPath(List<List<Stack<Integer>>> path) {
    for (int i = 0; i < path.size(); i++) {
      List<Stack<Integer>> stacks = path.get(i);
      System.out.println(i + ": " + stacks);
    }
  }

  private static List<List<Stack<Integer>>> hanoiRecursion(List<List<Stack<Integer>>> path) {
    List<Stack<Integer>> position = path.get(path.size() - 1);
    int n = position.get(0).size();
    moveDisks(n, path, 0, 1, 2);
    return path;
  }

  private static void moveDisks(int n, List<List<Stack<Integer>>> path, int source, int buffer,
      int dest) {
    if(n > 0) {
      moveDisks(n - 1, path, source, dest, buffer);
      List<Stack<Integer>> position = path.get(path.size() - 1);
      List<Stack<Integer>> currentPosition = copyPosition(position);
      Integer top = currentPosition.get(source).pop();
      currentPosition.get(dest).push(top);
      path.add(currentPosition);
      moveDisks(n - 1, path, buffer, source, dest);
    }
  }


  @SuppressWarnings("unused")
  private static List<List<Stack<Integer>>> hanoiDfs(List<List<Stack<Integer>>> path,
      List<String> visited) {
    List<Stack<Integer>> position = path.get(path.size() - 1);
    if (checkSolution(position)) {
      return path;
    }
    visited.add(position.toString());
    List<Stack<Integer>> currentPosition = copyPosition(position);
    for (int i = 0; i < currentPosition.size(); i++) {
      Stack<Integer> tower = currentPosition.get(i);
      if (tower.isEmpty()) {
        continue;
      }
      Integer disk = tower.pop();
      for (int j = 0; j < currentPosition.size(); j++) {
        Stack<Integer> otherTower = currentPosition.get(j);
        if (i != j && (otherTower.isEmpty() || otherTower.peek() > disk)) {
          otherTower.push(disk);
          if (!visited.contains(currentPosition.toString())) {
            List<Stack<Integer>> newPosition = getNewPosition(currentPosition);
            List<List<Stack<Integer>>> newPath = new ArrayList<>(path);
            newPath.add(newPosition);
            List<List<Stack<Integer>>> result = hanoiDfs(newPath, visited);
            if (result != null) {
              return result;
            }
          }
          otherTower.pop();
        }
      }
      tower.push(disk);
    }
    return new ArrayList<>();
  }

  @SuppressWarnings("unused")
  private static List<List<Stack<Integer>>> hanoiBfs(List<List<Stack<Integer>>> initPath,
      List<String> visited) {
    Queue<List<List<Stack<Integer>>>> queue = new ArrayDeque<>();
    queue.add(initPath);
    while (!queue.isEmpty()) {
      List<List<Stack<Integer>>> path = queue.remove();
      List<Stack<Integer>> position = path.get(path.size() - 1);
      if (checkSolution(position)) {
        return path;
      }
      visited.add(position.toString());
      List<Stack<Integer>> currentPosition = copyPosition(position);
      for (int i = 0; i < currentPosition.size(); i++) {
        Stack<Integer> tower = currentPosition.get(i);
        if (tower.isEmpty()) {
          continue;
        }
        Integer disk = tower.pop();
        for (int j = 0; j < currentPosition.size(); j++) {
          Stack<Integer> otherTower = currentPosition.get(j);
          if (i != j && (otherTower.isEmpty() || otherTower.peek() > disk)) {
            otherTower.push(disk);
            if (!visited.contains(currentPosition.toString())) {
              List<Stack<Integer>> newPosition = getNewPosition(currentPosition);
              List<List<Stack<Integer>>> newPath = new ArrayList<>(path);
              newPath.add(newPosition);
              queue.add(newPath);
            }
            otherTower.pop();
          }
        }
        tower.push(disk);
      }
    }
    return new ArrayList<>();
  }

  private static List<Stack<Integer>> getNewPosition(List<Stack<Integer>> currentPosition) {
    List<Stack<Integer>> newPosition = new ArrayList<>();
    for (Collection<Integer> tower : currentPosition) {
      Stack<Integer> newStack = new Stack<>();
      newStack.addAll(tower);
      newPosition.add(newStack);
    }
    return newPosition;
  }

  private static List<Stack<Integer>> copyPosition(List<Stack<Integer>> position) {
    List<Stack<Integer>> currentPosition = new ArrayList<>();
    for (Collection<Integer> tower : position) {
      Stack<Integer> s = new Stack<>();
      s.addAll(tower);
      currentPosition.add(s);
    }
    return currentPosition;
  }

  private static boolean checkSolution(List<Stack<Integer>> position) {
    int emptyTowers = 0;
    for (List<Integer> tower : position) {
      if (tower.isEmpty()) {
        emptyTowers++;
      }
    }
    return position.get(0).isEmpty() && emptyTowers == position.size() - 1;
  }

}
