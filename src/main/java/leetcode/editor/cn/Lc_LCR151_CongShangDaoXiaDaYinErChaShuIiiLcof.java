package leetcode.editor.cn;


import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Lc_LCR151_CongShangDaoXiaDaYinErChaShuIiiLcof{
    public static void main(String[] args) {
    
        Solution solution = new Lc_LCR151_CongShangDaoXiaDaYinErChaShuIiiLcof()
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
    public List<List<Integer>> decorateRecord(TreeNode root) {
        // 使用双端队列
        // ans.size() 表示 二叉树的第 n 层
        List<List<Integer>> ans = new LinkedList<>();
        if(root == null)return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            LinkedList<Integer> tmp = new LinkedList<>();
            for (int i = 0;i < size;i++){
                TreeNode node = queue.poll();
                if(ans.size() %2 == 0){
                    // 偶数层 从 队尾部进 tmp
                    tmp.addLast(node.val);
                }else {
                    // 奇数层 从队头进
                    tmp.addFirst(node.val);
                }
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            ans.add(tmp);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}