package leetcode.editor.cn;


public class Lc_328_OddEvenLinkedList{
    public static void main(String[] args) {
    
        Solution solution = new Lc_328_OddEvenLinkedList()
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
    public ListNode oddEvenList(ListNode head) {
        if(head == null)return null;
        // 奇数节点头节点
        ListNode oddHead = head;
        // 偶数节点头节点
        ListNode evenHead = head.next;
        // 当前 奇数 节点
        ListNode odd = head;
        // 当前 偶数节点
        ListNode even = evenHead;
        while (even != null && even.next != null){
            odd.next = even.next;
            odd = odd.next;

            even.next = odd.next;
            even = odd.next;
        }
        odd.next = evenHead;
        return head;

    }
}
//leetcode submit region end(Prohibit modification and deletion)


}