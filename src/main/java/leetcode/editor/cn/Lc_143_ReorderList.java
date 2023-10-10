package leetcode.editor.cn;


public class Lc_143_ReorderList{
    public static void main(String[] args) {
    
        Solution solution = new Lc_143_ReorderList()
                            .new Solution();
        ListNode node = build(1);
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
        ListNode l2 = traverse(after);
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
    private ListNode traverse(ListNode root){
        if(root == null || root.next == null){
            return root;
        }
        ListNode head = traverse(root.next);
        root.next.next = root;
        root.next = null;
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}