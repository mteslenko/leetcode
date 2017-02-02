package leetcode.tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * For a undirected graph with tree characteristics, we can choose any node as the root. The result
 * graph is then a rooted tree. Among all possible rooted trees, those with minimum height are
 * called minimum height trees (MHTs). Given such a graph, write a function to find all the MHTs
 * and return a list of their root labels.
 * <p>
 * <b>Format:</b>
 * </p>
 * <p>
 * The graph contains n nodes which are labeled from {@code 0} to {@code n - 1}.
 * You will be given the number n and a list of undirected edges (each edge is a pair of labels).
 * </p>
 * <p>
 * You can assume that no duplicate edges will appear in edges. Since all edges are undirected,
 * [0, 1] is the same as [1, 0] and thus will not appear together in edges.
 * </p>
 *
 * @see <a href="https://leetcode.com/problems/minimum-height-trees/">Leetcode</a>
 */
class MinimumHeightTrees {
  List<Integer> findMinHeightTrees(int n, int[][] edges) {
    if (n == 0) {
      return new ArrayList<>();
    }
    if (n == 1) {
      return Collections.singletonList(0);
    }
    Map<Integer, Set<Integer>> adj = new HashMap<>();
    Arrays.stream(edges).forEach(edge -> {
      adj.computeIfAbsent(edge[0], k -> new HashSet<>()).add(edge[1]);
      adj.computeIfAbsent(edge[1], k -> new HashSet<>()).add(edge[0]);
    });
    Set<Integer> leaves = adj.entrySet()
        .stream()
        .filter(e -> e.getValue().size() == 1)
        .map(Entry::getKey)
        .collect(Collectors.toSet());
    while (n > 2) {
      n -= leaves.size();
      leaves = leaves.stream().map(leaf -> {
        Integer neighbor = adj.get(leaf).iterator().next();
        adj.get(neighbor).remove(leaf);
        return neighbor;
      }).filter(neighbor -> adj.get(neighbor).size() == 1).collect(Collectors.toSet());
    }
    return new ArrayList<>(leaves);
  }
}
