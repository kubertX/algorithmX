package leetcode.editor.cn;


public class Lc_142_LinkedListCycleIi{
    
    public static void main(String[] args) {
    
        Solution solution = new Lc_142_LinkedListCycleIi()
        .new Solution();
    }


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                // 说明有环
                break;
            }
        }
        // 五环
        if(fast == null || fast.next == null){
            return null;
        }
        slow = head;
        while (slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;

    }
}
//leetcode submit region end(Prohibit modification and deletion)


}