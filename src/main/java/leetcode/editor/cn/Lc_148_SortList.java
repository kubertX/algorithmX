package leetcode.editor.cn;


public class Lc_148_SortList{
    
    public static void main(String[] args) {
    
        Solution solution = new Lc_148_SortList()
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
    public ListNode sortList(ListNode head) {

        return sorted(head);
    }

    //
    private ListNode sorted(ListNode head){
        if (head == null || head.next == null){
            return head;
        }

        ListNode mid = findMid(head);
        ListNode head2 = mid.next;
        mid.next = null;
        // [head,mid)
        ListNode l1 = sorted(head);
        ListNode l2 = sorted(head2);
        return merge(l1,l2);
    }

    private ListNode merge(ListNode l1,ListNode l2){
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        ListNode p1 = l1;
        ListNode p2 = l2;
        while (p1 != null && p2 != null){
            if(p1.val <= p2.val){
                p.next = p1;
                p1 = p1.next;
            }else {
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }
        if(p1 != null){
            p.next = p1;
        }
        if(p2 != null){
            p.next = p2;
        }
        return dummy.next;
    }

    private ListNode findMid(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next.next;
        if(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}