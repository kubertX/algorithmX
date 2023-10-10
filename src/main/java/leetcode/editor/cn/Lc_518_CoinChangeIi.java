package leetcode.editor.cn;


public class Lc_518_CoinChangeIi{
    public static void main(String[] args) {
    
        Solution solution = new Lc_518_CoinChangeIi()
                            .new Solution();
    }


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int change(int amount, int[] coins) {

        // dp[i][j] 表示用 前 i 个数值面额的硬币 凑出 j 块钱的方法有多少种
        // dp[i][j] = dp[i-1][j]  // 使用前 i-1 个面额 凑出 j 块钱
        //              +
        //            dp[i][j-coins[i-1]] // 使用前 i 个面额 凑出 j-cost[i-1 块前
        int n = coins.length;
        int[][] dp = new int[n+1][amount+1];
        // base case
        for (int i = 0;i <= n;i++){
            // 使用i种硬币凑出0元
            dp[i][0] = 1;
        }
        for (int i = 1;i <= n;i++){
            for (int j = 1;j <= amount;j++){
                if(j - coins[i-1] >= 0){
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][amount];
    }

}
//leetcode submit region end(Prohibit modification and deletion)


}