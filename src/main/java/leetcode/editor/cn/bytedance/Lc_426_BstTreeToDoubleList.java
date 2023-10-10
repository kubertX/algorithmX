package leetcode.editor.cn.bytedance;

import leetcode.editor.cn.Node;
import leetcode.editor.cn.TreeNode;

/**
 * @ClassName Lc_426_BstTreeToDoubleList
 * @Description TODO
 * @Author xuyubin6
 * @Date 2023/10/10 15:07
 */
public class Lc_426_BstTreeToDoubleList {

    public static void main(String[] args) {

    }

    class Solution {
        Node first;
        Node pre;

        public Node treeToDoublyList(TreeNode root) {
            if (root == null) return null;
            first = pre = null;
            inorder(root);
            first.left = pre;
            pre.right = first;
            return first;
        }

        public void inorder(TreeNode root) {
            if(root == null){
                return;
            }
            inorder(root.left);
            Node cur = new Node(root.val);
            // 中序
            if(first == null){
                // 头节点为空
                first = cur;
            }
            if(pre == null){
                pre = first;
            }else {
                pre.right = cur;
                cur.left = pre;
                pre = cur;
            }
            inorder(root.right);
        }
    }

}
