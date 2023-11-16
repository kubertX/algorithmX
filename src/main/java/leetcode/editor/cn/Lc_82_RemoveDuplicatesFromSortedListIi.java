package leetcode.editor.cn;


public class Lc_82_RemoveDuplicatesFromSortedListIi{
    public static void main(String[] args) {
    
        Solution solution = new Lc_82_RemoveDuplicatesFromSortedListIi()
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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        //从指针 cur 指向链表的哑节点，随后开始对链表进行遍历。
        // 如果当前 cur.next 与 cur.next.next 对应的元素相同，
        // 那么我们就需要将 cur.next 以及所有后面拥有相同元素值的链表节点全部删除。
        // 我们记下这个元素值 xxx，随后不断将 cur.next从链表中移除，
        // 直到 cur.next 为空节点或者其元素值不等于 xxx 为止。
        // 此时，我们将链表中所有元素值为 xxx 的节点全部删除。

        ListNode dummy = new ListNode(0, head);

        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int x = cur.next.val;
                while (cur.next != null && cur.next.val == x) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }

        return dummy.next;
    }


}
//leetcode submit region end(Prohibit modification and deletion)


}