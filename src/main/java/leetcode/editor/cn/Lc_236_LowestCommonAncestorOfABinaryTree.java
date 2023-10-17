package leetcode.editor.cn;


public class Lc_236_LowestCommonAncestorOfABinaryTree{
    public static void main(String[] args) {
    
        Solution solution = new Lc_236_LowestCommonAncestorOfABinaryTree()
                            .new Solution();
    }


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return findParent(root,p,q);
    }

    private TreeNode findParent(TreeNode root,TreeNode p,TreeNode q){
        if(root == null){
            return null;
        }
        if(root ==p || root ==q){
            // 本身就是最近公共祖先
            return root == p?p:q;
        }
        // 遍历左右节点找公共祖先
        TreeNode left = findParent(root.left, p, q);
        TreeNode right = findParent(root.right, p, q);
        if(left != null && right != null){
            // 左右节点都找到了，本身就是公共父节点
            return root;
        }
        return left != null? left:right;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}