package leetcode.editor.cn;


import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Lc_103_BinaryTreeZigzagLevelOrderTraversal{
    public static void main(String[] args) {
    
        Solution solution = new Lc_103_BinaryTreeZigzagLevelOrderTraversal()
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        // 双端队列，头尾都能添加元素
        // 解决思路
        // 偶数层节点 从 尾 添加进双端队列
        // 奇数层节点 从 头 添加进双端队列
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new LinkedList<>();
        if(root == null)return res;
        queue.add(root);
        while (!queue.isEmpty()){
            LinkedList<Integer> tmp = new LinkedList<>();
            int size = queue.size();
            for (int i = 0;i < size;i++){
                TreeNode cur = queue.poll();
                // res.size 表示当前层数
                if(res.size() %2 == 0){
                    tmp.addLast(cur.val);
                }else {
                    tmp.addFirst(cur.val);
                }
                if (cur.left != null)queue.add(cur.left);
                if (cur.right != null)queue.add(cur.right);
            }
            res.add(tmp);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}