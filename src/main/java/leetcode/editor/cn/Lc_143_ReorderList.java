package leetcode.editor.cn;


public class Lc_143_ReorderList{
    public static void main(String[] args) {
    
        Solution solution = new Lc_143_ReorderList()
                            .new Solution();
        ListNode node = build(1,2,3,4);
        solution.reorderList(node);
    }

    public static ListNode build(int... args){
        ListNode dy = new ListNode(-1);
        ListNode p = dy;
        for (int num : args) {
            p.next = new ListNode(num);
            p = p.next;
        }
        return dy.next;
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

    public void reorderList(ListNode head) {

        // 1. 找到链表中间节点
        ListNode slow = head;
        ListNode fast = head.next;
        // 1.1  1,2,3,4 中间节点为 3 此时 slow = 2,fast = 4
        // 1.2  1,2,3,4,5,中间节点为 3，此时 slow = 3，fast = null
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        // 前半段节点数 - 后半段节点 = 0/1
        ListNode mid = slow.next;
        // 断开连接
        slow.next = null;

        // 2. 从中间开始翻转链表
        ListNode l1 = head;
        ListNode l2 = reverse(mid);

        // 3. 合并链表
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        ListNode p1 = l1;
        ListNode p2 = l2;
        while (p1 != null && p2 != null){
            p.next = p1;
            p1 = p1.next;
            p = p.next;

            p.next = p2;
            p2 = p2.next;
            p = p.next;
        }
        if(p1 != null){
            while (p1 != null){
                p.next = p1;
                p = p.next;
                p1 = p1.next;
            }
        }

        head = dummy.next;

    }

    private ListNode reverse(ListNode head){
        if(head == null || head.next == null){
            return head;
        }

        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public void reorderList1(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode after = slow.next;
        slow.next = null;
        ListNode l1 = head;
        ListNode l2 = traverse1(after);
        ListNode dummy1 = new ListNode(-1);
        ListNode p = dummy1;
        while (l1 != null && l2 != null){
            p.next = l1;
            l1 = l1.next;
            p = p.next;

            p.next = l2;
            l2 = l2.next;
            p = p.next;

            //p.next = null;
        }
        if(l1 != null){
            p.next = l1;
        }
        head = dummy1.next;

    }

    /**
     * 翻转链表
     * @param root
     * @return
     */
    private ListNode traverse1(ListNode root){
        if(root == null || root.next == null){
            return root;
        }
        ListNode head = traverse1(root.next);
        root.next.next = root;
        root.next = null;
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}