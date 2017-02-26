package others.tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Build a binary tree using a list of (nodeId, parentNodeId)
 */
public class MakeTree {

  public static void main(String[] args) {
    Node root = new MakeTree().makeTree(Arrays.asList(new TreeNode("c", "a"),
        new TreeNode("b", "a"),
        new TreeNode("d", "b")));
    System.out.println(root.id);
    System.out.println(root.children.get(0).id);
    System.out.println(root.children.get(1).id);
    System.out.println(root.children.get(1).children.get(0).id);
  }

  private Node makeTree(List<TreeNode> entries) {
    Map<String, Node> existingNodes = new HashMap<>();
    Map<String, Node> rootCandidates = new HashMap<>();
    Map<String, Node> childNodes = new HashMap<>();
    for (TreeNode entry : entries) {
      String nodeId = entry.nId;
      Node exNode = existingNodes.computeIfAbsent(nodeId, k -> new Node(nodeId));
      String parentId = entry.pId;
      Node exParent = existingNodes.computeIfAbsent(parentId, k -> new Node(parentId));

      exParent.addChild(exNode);
      childNodes.put(nodeId, exNode);
      if (childNodes.get(parentId) == null) {
        rootCandidates.put(parentId, exParent);
      }
      if (rootCandidates.get(nodeId) != null) {
        rootCandidates.remove(nodeId);
      }
    }
    return rootCandidates.entrySet().iterator().next().getValue();
  }

  private static final class Node {
    private String id;
    private List<Node> children = new ArrayList<>();

    private Node(String id) {
      this.id = id;
    }

    public void addChild(Node exNode) {
      children.add(exNode);
    }
  }

  private static final class TreeNode {
    private String nId;
    private String pId;

    private TreeNode(String nId, String pId) {
      this.nId = nId;
      this.pId = pId;
    }
  }

}
