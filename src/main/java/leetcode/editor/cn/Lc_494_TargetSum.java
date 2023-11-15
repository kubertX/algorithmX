package leetcode.editor.cn;


public class Lc_494_TargetSum{
    
    public static void main(String[] args) {
    
        Solution solution = new Lc_494_TargetSum()
        .new Solution();
    }


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private int count;
    public int findTargetSumWays(int[] nums, int target) {

        // dp[i][j] : 表示用 数组 前 i 个元素组成 和 为 j 的 个数
        // dp[i][j] = dp[i-1][j-nums[i]] + dp[i-1][j+[nums[i]]



        dfs(nums,0,0,target);
        return count;
    }

    private void dfs(int[] nums,int index,int curSum,int target){
        if(index == nums.length){
            if(curSum == target){
                count++;
            }
            return;
        }

        // +num
        curSum += nums[index];
        dfs(nums,index+1,curSum,target);
        curSum -= nums[index];

        // -num
        curSum -= nums[index];
        dfs(nums,index+1,curSum,target);
        curSum += nums[index];
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}