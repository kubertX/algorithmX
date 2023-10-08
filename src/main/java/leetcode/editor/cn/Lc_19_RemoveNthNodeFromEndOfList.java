package leetcode.editor.cn;


import java.util.List;

public class Lc_19_RemoveNthNodeFromEndOfList{
    public static void main(String[] args) {
    
        Solution solution = new Lc_19_RemoveNthNodeFromEndOfList()
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 快慢指针
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode node = findNthNode(dummy, n + 1);
        node.next = node.next.next;
        return dummy.next;


    }

    /**
     * 找到倒数第n个节点
     * @param head
     * @param n
     * @return
     */
    private ListNode findNthNode(ListNode head,int n){
        ListNode fast = head;
        // fast 先走 n 步
        while (n > 0){
            fast = fast.next;
            n--;
        }
        ListNode slow = head;
        while (fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;

    }
}
//leetcode submit region end(Prohibit modification and deletion)


}