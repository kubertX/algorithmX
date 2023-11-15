package leetcode.editor.cn;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

public class Lc_662_MaximumWidthOfBinaryTree{
    
    public static void main(String[] args) {
    
        Solution solution = new Lc_662_MaximumWidthOfBinaryTree()
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
    public int widthOfBinaryTree(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        int max = 0;
        deque.add(new TreeNode(1,root.left,root.right));
        while (!deque.isEmpty()){
            int count = deque.size();
            int startIndex = -1;
            int endIndex = -1;
            for (int i = 0;i  < count;i++){
                TreeNode node = deque.pop();
                if(startIndex == -1){
                    // 找到当前层数的第一个节点的编号
                    startIndex = node.val;
                }
                endIndex = node.val;
                if(node.left != null){
                    deque.addLast(new TreeNode(2*node.val,node.left.left,node.left.right));
                }
                if(node.right != null){
                    // 构造新的右节点（带编号）
                    deque.addLast(new TreeNode(2*node.val+1,node.right.left,node.right.right));
                }
                max = Math.max(max,endIndex-startIndex+1);
            }
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}