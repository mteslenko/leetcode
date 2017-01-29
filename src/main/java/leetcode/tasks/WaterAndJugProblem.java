package leetcode.tasks;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

/**
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of
 * shortest transformation sequence from beginWord to endWord.
 *
 * @see <a href="https://leetcode.com/problems/water-and-jug-problem">Leetcode</a>
 */
class WaterAndJugProblem {
  boolean canMeasureWater(int x, int y, int z) {
    Queue<List<State>> states = new ArrayDeque<>();
    states.add(Collections.singletonList(new State(0, 0, "Start")));
    List<State> visited = new ArrayList<>();
    while (!states.isEmpty()) {
      List<State> path = states.poll();
      State current = path.get(path.size() - 1);
      if (visited.contains(current)) {
        path.clear();
        continue;
      }
      if (current.jug1 == z || current.jug2 == z || current.jug1 + current.jug2 == z) {
//        System.out.println(path);
        return true;
      }
      visited.add(current);
      addStateToQueue(states,
          visited,
          path, new State(x, current.jug2, String.format("Fill %d (%d, %d)", x, x, current.jug2)));
      addStateToQueue(states,
          visited,
          path, new State(current.jug1, y, String.format("Fill %d (%d, %d)", y, current.jug1, y)));
      addStateToQueue(states,
          visited,
          path,
          new State(0,
              current.jug2,
              String.format("Empty %d (%d, %d)", current.jug1, 0, current.jug2)));
      addStateToQueue(states,
          visited,
          path,
          new State(current.jug1,
              0,
              String.format("Empty %d (%d, %d)", current.jug2, current.jug1, 0)));
      int jug1Left = Math.max(0, current.jug1 - (y - current.jug2));
      int jug2Got = Math.min(y, current.jug2 + current.jug1);
      addStateToQueue(states, visited, path, new State(jug1Left,
          jug2Got,
          String.format("Pour %d -> %d (%d, %d)", current.jug1, current.jug2, jug1Left, jug2Got)));
      int jug1Got = Math.min(x, current.jug1 + current.jug2);
      int jug2Left = Math.max(0, current.jug2 - (x - current.jug1));
      addStateToQueue(states, visited, path, new State(jug1Got,
          jug2Left,
          String.format("Pour %d -> %d (%d, %d)", current.jug2, current.jug1, jug1Got, jug2Left)));
    }
    return false;
  }

  private void addStateToQueue(Queue<List<State>> states, List<State> visited, List<State> path,
      State newState) {
    if (!visited.contains(newState)) {
      List<State> newPath = new ArrayList<>(path);
      newPath.add(newState);
      states.add(newPath);
    }
  }

  private static final class State {
    private final int jug1;
    private final int jug2;
    private String action;

    private State(int jug1, int jug2, String action) {
      this.jug1 = jug1;
      this.jug2 = jug2;
      this.action = action;
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      }
      if (obj == null || getClass() != obj.getClass()) {
        return false;
      }
      State state = (State) obj;
      return jug1 == state.jug1 && jug2 == state.jug2;
    }

    @Override
    public int hashCode() {
      return Objects.hash(jug1, jug2);
    }

    @Override
    public String toString() {
      return action;
    }
  }
}
