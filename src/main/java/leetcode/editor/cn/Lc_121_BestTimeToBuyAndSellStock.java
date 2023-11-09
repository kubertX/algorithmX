package leetcode.editor.cn;


import java.nio.channels.Pipe;

public class Lc_121_BestTimeToBuyAndSellStock{
    public static void main(String[] args) {
    
        Solution solution = new Lc_121_BestTimeToBuyAndSellStock()
                            .new Solution();
    }


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfit(int[] prices) {
        // dp[i][k][0 or 1] 第 i 天进行k次交易后 ，持有/不持有 股票的 最大收益
        // 一次买入次数+1
        //  dp[i][k][0] = max(dp[i-1][k][0],dp[i-1][k][1]+price[i])
        //  dp[i][k][1] = max(dp[i-1][k][0],dp[i-1][k-1][0]-price[i])
        // base case
        // dp[-1][...][0]=0 , dp[-1][...][1] = -oo
        // dp[...][0][0] = 0  dp[...][0][1] = -oo

        // k = 1时，dp[i][1][0] = max(dp[i-1][1][0],dp[i-1][1][1]+prices)
        //          dp[i][1][1] = max(dp[i-1][1][1],dp[i-1][0][0]-pices[i])
        //                      = max(dp[i-1][1][1],-prices[i]);

        int[][] dp = new int[prices.length][2];
        for (int i = 0;i < prices.length;i++){
            if(i-1 == -1){
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
                continue;
            }
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            dp[i][1] = Math.max(dp[i-1][1],-prices[i]);

        }
        return dp[prices.length-1][0];

    }
}
//leetcode submit region end(Prohibit modification and deletion)


}