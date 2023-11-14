package leetcode.editor.cn;


public class Lc_213_HouseRobberIi{
    
    public static void main(String[] args) {
    
        Solution solution = new Lc_213_HouseRobberIi()
        .new Solution();
    }


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1)return nums[0];
        //  环形数组，首尾不能同时被抢，有3种情况：
        // 1. 首尾不抢 2.首抢尾不抢 3.首不抢尾抢
        int n = nums.length;
        return Math.max(maxRob(nums,0,n-2),
                maxRob(nums,1,n-1));
    }

    public int maxRob(int[] nums,int start,int end){
        int dp_i_1 = 0;
        int dp_i_2 = 0;
        int dp_i = 0;
        for(int i = end ;i >= start;i-- ){
            dp_i = Math.max(dp_i_1,nums[i]+dp_i_2);
            dp_i_2 = dp_i_1;
            dp_i_1 = dp_i;
        }
        return dp_i;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}