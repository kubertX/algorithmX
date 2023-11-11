package leetcode.editor.cn;


import java.util.HashMap;
import java.util.Map;

public class Lc_1171_RemoveZeroSumConsecutiveNodesFromLinkedList{
    public static void main(String[] args) {
    
        Solution solution = new Lc_1171_RemoveZeroSumConsecutiveNodesFromLinkedList()
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
    public ListNode removeZeroSumSublists(ListNode head) {
        // 前缀和 + 哈希表
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // 前缀和map
        Map<Integer,ListNode> prefixMap = new HashMap<>();
        int sum = 0;
        for (ListNode d = dummy;d != null;d = d.next){
            sum += d.val;
            prefixMap.put(sum,d);
        }

        // 二次遍历，指向最新的相同前缀和节点
        int prefix = 0;
        for (ListNode d = dummy;d != null;d = d.next){
            prefix += d.val;
            d.next = prefixMap.get(prefix).next;
        }
        return dummy.next;

    }
}
//leetcode submit region end(Prohibit modification and deletion)


}