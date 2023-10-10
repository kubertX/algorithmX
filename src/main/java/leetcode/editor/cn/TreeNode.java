package leetcode.editor.cn;

/**
 * @ClassName TreeNode
 * @Description TODO
 * @Author xuyubin6
 * @Date 2023/10/10 14:46
 */
public class TreeNode {

    public int val;
    public   TreeNode left;
    public   TreeNode right;
  TreeNode() {}
  TreeNode(int val) { this.val = val; }
  TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
  }
}
