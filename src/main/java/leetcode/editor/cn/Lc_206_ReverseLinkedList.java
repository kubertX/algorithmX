package leetcode.editor.cn;


public class Lc_206_ReverseLinkedList{
    
    public static void main(String[] args) {
    
        Solution solution = new Lc_206_ReverseLinkedList()
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

    // 1 2 3 4 5
    // 1 2 3 4
    //     5
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode node = reverseList(head.next);

        head.next.next = head;
        head.next = null;
        return node;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}