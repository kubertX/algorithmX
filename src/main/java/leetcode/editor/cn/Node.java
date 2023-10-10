package leetcode.editor.cn;

/**
 * @ClassName Node
 * @Description TODO
 * @Author xuyubin6
 * @Date 2023/10/10 15:32
 */
public class Node {

    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}
