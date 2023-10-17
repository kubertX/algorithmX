package leetcode.editor.cn;


public class Lc_129_SumRootToLeafNumbers{
    public static void main(String[] args) {
    
        Solution solution = new Lc_129_SumRootToLeafNumbers()
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

    private int totalSum;
    public int sumNumbers(TreeNode root) {
        backTrack(root,0);
        return totalSum;
    }

    private void backTrack(TreeNode root,int curSum){
        if(root == null)return;
        curSum = (curSum*10)+root.val;
        if(root.left == null && root.right == null){
            totalSum += curSum;
        }
        backTrack(root.left,curSum);
        backTrack(root.right,curSum);

    }
}
//leetcode submit region end(Prohibit modification and deletion)


}