package leetcode.editor.cn;


import java.util.List;

public class Lc_53_MaximumSubarray{
    public static void main(String[] args) {
    
        Solution solution = new Lc_53_MaximumSubarray()
                            .new Solution();
    }


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSubArray(int[] nums) {

        // 以当前角标i为结尾的最大子数组和
        // dp[i] = max(dp[i-1]+nums[i],nump[i]);

        int[] dp = new int[nums.length];
        // basecase
        dp[0] = nums[0];
        for (int i = 1;i < nums.length;i++){
            dp[i] = Math.max(dp[i-1]+nums[i],nums[i]);
        }
        int max = dp[0];
        for (int cur : dp) {
            max = Math.max(cur,max);
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}