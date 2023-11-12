package leetcode.editor.cn;

public class LCUtils {

    public static ListNode build(int[] nums){
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        for (int num : nums) {
            p.next = new ListNode(num);
            p = p.next;
        }
        return dummy.next;

    }
}
