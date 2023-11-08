package leetcode.editor.cn;


public class Lc_221_MaximalSquare{
    public static void main(String[] args) {
    
        Solution solution = new Lc_221_MaximalSquare()
                            .new Solution();
    }


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximalSquare(char[][] matrix) {
        // dp(i,j)表示以i，j为右下角的最大正方形边长
        // num[i,j] = 0,dp[i,j] = 0
        // num[i,j] = 1,dp[i,j] = min( dp[i-1,j],dp[i,j-1],dp[i-1,j-1]) + 1
        // = 1 时，取决于正方形另外三个角的取值
        int maxSide = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0;i < matrix.length;i++){
            for (int j = 0;j< matrix[0].length;j++){
                if(matrix[i][j] == '1'){
                    if(i == 0|| j== 0){
                        // 边界值 跟 当前值相等
                        dp[i][j] = matrix[i][j] - '0';
                    }else {
                        dp[i][j] = Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]))+1;
                    }
                }
                maxSide = Math.max(maxSide,dp[i][j]);

            }
        }
        return maxSide*maxSide;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}