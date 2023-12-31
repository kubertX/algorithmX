package leetcode.editor.cn;


public class Lc_72_EditDistance{
    
    public static void main(String[] args) {
    
        Solution solution = new Lc_72_EditDistance()
        .new Solution();
    }


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minDistance(String word1, String word2) {

        // dp[i][j] = 表示 word1[0,i] 替换成 word2[0,j] 需要的步数
        // word[i] = word2[j], dp[i][j] = dp[i-1][j-1]
        //        != word2[j] ,dp[i][j] = min(dp[i-1][j-1] ,dp[i-1][j],dp[i][j-1])+1

        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];
        // base case
        // dp[0][j] = j;  dp[i][0] = i;
        for (int i =0;i <= m;i++){
            for (int j = 0;j <= n;j++){
                if(i == 0){
                    dp[i][j] = j;
                }else if(j == 0){
                    dp[i][j] = i;
                }else {
                    if(word1.charAt(i-1) == word2.charAt(j-1)){
                        dp[i][j] = dp[i-1][j-1];
                    }else {
                        dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]))+1;
                    }
                }

            }
        }
        return dp[m][n];

    }
}
//leetcode submit region end(Prohibit modification and deletion)


}