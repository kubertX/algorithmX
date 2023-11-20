package leetcode.editor.cn;


import java.util.List;

public class Lc_61_RotateList{
    public static void main(String[] args) {
    
        Solution solution = new Lc_61_RotateList()
                            .new Solution();
    }


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        // 找到旋转的开始节点，断开为2个列表，收尾相连接
        int size = 0;
        ListNode p = head;
        while (p != null){
            p = p.next;
            size++;
        }
        // 取模
        k = k%size;
        if(k == 0)return head;
        int index = size - k ;

        ListNode p1 = head;
        for (int i = 1;i <= index;i++){
            p1 = p1.next;
        }

        ListNode p2 = p1.next;
        p1.next = null;

        ListNode tmp = p2;
        while (tmp.next != null){
            tmp = tmp.next;
        }
        tmp.next = head;

        return p2;


    }
}
//leetcode submit region end(Prohibit modification and deletion)


}