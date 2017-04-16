package leetcode.tasks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FindLargestValueInEachTreeRow {
  public List<Integer> largestValues(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    List<TreeNode> layer = Collections.singletonList(root);

    while (!layer.isEmpty()) {
      result.add(layer.stream().mapToInt(n -> n.val).max().orElse(0));
      layer = layer.stream()
          .filter(Objects::nonNull)
          .flatMap(n -> Stream.of(n.left, n.right)).filter(Objects::nonNull)
          .collect(Collectors.toList());
    }
    return result;
  }
}
