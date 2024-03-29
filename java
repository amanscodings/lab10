import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Main{
  public List<List<Integer>> levelOrder(TreeNode root) {
      List<List<Integer>> result = new ArrayList<>();
      if (root == null) {
          return result;
      }

      Queue<TreeNode> queue = new LinkedList<>();
      queue.add(root);

      while (!queue.isEmpty()) {
          int levelSize = queue.size();
          List<Integer> currentLevel = new ArrayList<>();

          for (int i = 0; i < levelSize; i++) {
              TreeNode node = queue.poll();
              currentLevel.add(node.val);

              if (node.left != null) {
                  queue.add(node.left);
              }
              if (node.right != null) {
                  queue.add(node.right);
              }
          }

          result.add(currentLevel);
      }

      return result;
  }


    public static void main(String[] args) {
      TreeNode root = new TreeNode(4);
      root.left = new TreeNode(3);
      root.right = new TreeNode(8);
      root.left.left = new TreeNode(1);
      root.right.left = new TreeNode(5);
      root.right.right = new TreeNode(9);
      
    Main main = new Main();
    List<List<Integer>> result = main.levelOrder(root);
    for (List<Integer> level : result) {
        for (int num : level) {
            System.out.print("[" + num + "]");
        }
          System.out.print(",");
          System.out.println();
    }
  }
}

