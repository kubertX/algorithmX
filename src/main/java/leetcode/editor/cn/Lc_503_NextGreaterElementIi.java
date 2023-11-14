package leetcode.editor.cn;


import java.util.Stack;

public class Lc_503_NextGreaterElementIi{
    
    public static void main(String[] args) {
    
        Solution solution = new Lc_503_NextGreaterElementIi()
        .new Solution();
    }


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        // 数组扩长2倍
        //   2 1 2 4 3
        //   2 1 2 4 3 2 1 2 4 3
        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 2*n -1;i >= 0;i--){
            // 找出第一个大于当前数
            while (!stack.isEmpty() && stack.peek() <= nums[i%n]){
                // 出栈
                stack.pop();
            }
            res[i%n] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i%n]);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}