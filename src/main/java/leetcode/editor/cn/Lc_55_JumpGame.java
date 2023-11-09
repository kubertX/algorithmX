package leetcode.editor.cn;


public class Lc_55_JumpGame{
    public static void main(String[] args) {
    
        Solution solution = new Lc_55_JumpGame()
                            .new Solution();
        solution.canJump(new int[]{0});
    }


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canJump(int[] nums) {
        // 贪心算法，是动态规划的一种
        // 求极值：转换为 最多能跳多远
        // fast > nums.length 返回true,否则返回faslse
        int n = nums.length;
        int fastIndex = 0;
        // 遍历到倒数第2个位置时，就能得到最远index
        for (int i = 0;i < n-1 ;i++){
            // 不断计算能够到达的最远距离
            fastIndex = Math.max(fastIndex,i+nums[i]);
            if(fastIndex <= i){
                return false;
            }
        }
        // 判断最远角标 是否大于 最后一个角标
        return fastIndex >= n-1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}