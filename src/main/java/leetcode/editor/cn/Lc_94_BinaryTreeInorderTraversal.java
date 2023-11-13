package leetcode.editor.cn;


import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Lc_94_BinaryTreeInorderTraversal{
    public static void main(String[] args) {
    
        Solution solution = new Lc_94_BinaryTreeInorderTraversal()
                            .new Solution();
    }


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        if (root == null){
            return ans;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null){
            while (cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode node = stack.pop();
            ans.add(node.val);
            if(node.right != null){
                cur = node.right;
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}