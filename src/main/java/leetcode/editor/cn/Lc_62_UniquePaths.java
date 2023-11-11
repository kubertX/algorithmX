package leetcode.editor.cn;


public class Lc_62_UniquePaths{
    
    public static void main(String[] args) {
    
        Solution solution = new Lc_62_UniquePaths()
        .new Solution();
    }


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int uniquePaths(int m, int n) {

        // dp[i,j] = dp[i-1][j] + dp[i][j-1]
        int[][] dp = new int[m][n];
        // base case
        // dp[..][0] = 1 ,dp[0][..] = 1;
        for (int i = 0;i < m;i ++){
            for (int j = 0;j < n;j++){
                if(i ==0 || j == 0){
                    dp[i][j] = 1;
                }else {
                    dp[i][j] = dp[i-1][j]+dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}