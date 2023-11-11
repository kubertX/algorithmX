package leetcode.editor.cn;


public class Lc_112_PathSum{
    
    public static void main(String[] args) {
    
        Solution solution = new Lc_112_PathSum()
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

    private boolean found;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        //if (root == null)return false;
        traverse(root,0,targetSum);
        return found;
    }


    public void traverse(TreeNode root,int sum,int target){

        if(root == null){
            return;
        }
        if(found) return;

        // 前序遍历
        sum+=root.val;
        if(root.left == null && root.right == null){
            // 叶子结点
            if(sum == target){
                found = true;
            }
        }
        traverse(root.left,sum,target);
        traverse(root.right,sum,target);
        sum-=root.val;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}