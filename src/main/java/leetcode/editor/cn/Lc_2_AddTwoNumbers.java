package leetcode.editor.cn;


public class Lc_2_AddTwoNumbers{
    public static void main(String[] args) {
    
        Solution solution = new Lc_2_AddTwoNumbers()
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        ListNode p1 = l1,p2 = l2;
        int carry = 0;
        while (p1 != null || p2 != null || carry != 0){
            int v1 = p1 == null? 0 : p1.val;
            int v2 = p2 == null? 0 : p2.val;
            int sum = v1 + v2 + carry;
            carry = sum/10;
            p.next = new ListNode(sum%10);
            p = p.next;
            p1 = p1 == null? null:p1.next;
            p2 = p2 == null? null:p2.next;
        }
        return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}