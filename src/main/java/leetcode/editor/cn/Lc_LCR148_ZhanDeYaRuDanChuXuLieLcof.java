package leetcode.editor.cn;


import java.util.Stack;

public class Lc_LCR148_ZhanDeYaRuDanChuXuLieLcof{
    
    public static void main(String[] args) {
    
        Solution solution = new Lc_LCR148_ZhanDeYaRuDanChuXuLieLcof()
        .new Solution();
    }


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean validateBookSequences(int[] putIn, int[] takeOut) {
        Stack<Integer> stack = new Stack<>();
        int takeIndex = 0;
        for (int put : putIn){
            // 进栈
            stack.push(put);
            while (!stack.isEmpty() && stack.peek() == takeOut[takeIndex]){
                // 出战
                stack.pop();
                takeIndex++;
            }
        }

        // 判断还有没有书没被拿走
        return stack.isEmpty();
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}