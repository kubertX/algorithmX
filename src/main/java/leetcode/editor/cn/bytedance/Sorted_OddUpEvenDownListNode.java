package leetcode.editor.cn.bytedance;

import leetcode.editor.cn.LCUtils;
import leetcode.editor.cn.ListNode;

public class Sorted_OddUpEvenDownListNode {

    public static void main(String[] args) {
        ListNode listNode = LCUtils.build(new int[]{1, 8, 3, 6, 5, 4});
        Solution solution = new Sorted_OddUpEvenDownListNode().new Solution();
        ListNode node = solution.sortedOddUpEvenDown(listNode);
        while (node != null){
            System.out.println(node.val);
            node = node.next;
        }

    }

    class Solution{

        // 排序 奇升 偶降 链表
        public ListNode sortedOddUpEvenDown(ListNode node){
            // 1. 拆分奇偶节点
            ListNode oddHead = node;
            ListNode evenHead = node.next;

            ListNode odd = oddHead;
            ListNode even = evenHead;
            // 到达最后一个偶数节点，跳出循环
            // 1 2 3 4 5
            // 1 - 3 - 4 - 5
            //    2 - 4 -5
            // 1-3-5
            while (even != null && even.next != null){
                // 奇数节点指向下一个奇数点
                odd.next = even.next;
                odd = odd.next;

                even.next = odd.next;
                even = even.next;
            }
            // 断开与最后一个偶数节点链接
            odd.next = null;


            // 2. 反转偶节点
            ListNode cur = evenHead;
            ListNode pre = null;
            while (cur != null){
                // 2 4 6
                // 4->6
                ListNode tmp = cur.next;
                cur.next = pre;
                // 2-> null
                pre = cur;
                // 4->6
                cur = tmp;
            }
            evenHead = pre;

            // 3. 合并奇偶链表
            ListNode dummy = new ListNode(-1);
            ListNode p = dummy;
            ListNode p1 = oddHead;
            ListNode p2 = evenHead;
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
    }
}
