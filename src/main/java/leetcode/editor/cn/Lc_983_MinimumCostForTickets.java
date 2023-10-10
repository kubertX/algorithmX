package leetcode.editor.cn;


import java.util.HashSet;
import java.util.Set;

public class Lc_983_MinimumCostForTickets{
    public static void main(String[] args) {
    
        Solution solution = new Lc_983_MinimumCostForTickets()
                            .new Solution();
    }


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int mincostTickets(int[] days, int[] costs) {

        // 动态规划
        // dp[i] = 表示从第i天起开始旅游的最低消费
        // cost[0,1,2]为dp[i]的三种选择
        // dp[i] = min(cost[0]+dp[i+1],cost[1]+dp[i+7],cost[2]+dp[i+30]);

        int length = days.length;
        Set<Integer> travelSet = new HashSet<>();
        for (int day : days) {
            travelSet.add(day);
        }

        int minDay = days[0];
        int maxDay = days[length-1];
        int[] dp = new int[maxDay + 31];
        // 从后往前遍历
        for (int curDay = maxDay;curDay >= minDay;curDay--){
            if(travelSet.contains(curDay)){
                // 当天要旅游
                dp[curDay] = Math.min(costs[0]+dp[curDay+1],costs[1]+dp[curDay+7]);
                dp[curDay] = Math.min(dp[curDay],costs[2]+dp[curDay+30]);
            }else {
                // 今天不需要旅行，保持跟后一天的旅游开销一样
                dp[curDay] = dp[curDay+1];
            }
        }
        return dp[minDay];
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}