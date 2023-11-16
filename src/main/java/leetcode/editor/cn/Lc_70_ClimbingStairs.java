package leetcode.editor.cn;


public class Lc_70_ClimbingStairs{
    public static void main(String[] args) {
    
        Solution solution = new Lc_70_ClimbingStairs()
                            .new Solution();
    }


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int climbStairs(int n) {
        if(n < 2)return n;
        int dp_i = 1;
        int dp_i_1 = 1;
        int dp_i_2 = 1;
        for (int i = 2;i <= n;i++){
            dp_i = dp_i_1 + dp_i_2;
            dp_i_2 = dp_i_1;
            dp_i_1 = dp_i;
        }

        return dp_i;

    }
}
//leetcode submit region end(Prohibit modification and deletion)


}