package leetcode.editor.cn;


import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Lc_144_BinaryTreePreorderTraversal{
    public static void main(String[] args) {
    
        Solution solution = new Lc_144_BinaryTreePreorderTraversal()
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
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null)return new LinkedList<>();

        Stack<TreeNode> stack = new Stack<>();
        List<Integer> ans = new LinkedList<>();
        stack.push(root);
        TreeNode cur = null;
        while (!stack.isEmpty()){
            // 中
            cur = stack.pop();
            ans.add(cur.val);
            // 右节点晚于左节点访问，右节点先进栈
            if(cur.right != null){
                stack.push(cur.right);
            }
            if(cur.left != null){
                stack.push(cur.left);
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}