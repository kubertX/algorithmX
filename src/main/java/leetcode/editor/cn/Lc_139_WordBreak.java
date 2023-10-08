package leetcode.editor.cn;


import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lc_139_WordBreak{
    public static void main(String[] args) {
    
        Solution solution = new Lc_139_WordBreak()
                            .new Solution();
    }


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public Set<String> dict ;
    public int[] memo;
    public boolean wordBreak(String s, List<String> wordDict) {
        this.dict = new HashSet<>(wordDict);
        this.memo = new int[s.length()];
        // -1 未计算
        // 0 未找到
        // 1 能找到
        Arrays.fill(memo,-1);
        return dp(s,0);
    }

    // dp 函数表示能 能不能找到 word[start..] 在字典中匹配
    public boolean dp(String word,int start){
        if(start == word.length()){
            return true;
        }
        if(memo[start] != -1){
            return memo[start] == 1;
        }

        for (int len = 1;start + len <= word.length();len++){
            String substring = word.substring(start, start + len);
            if(dict.contains(substring)){
                boolean after = dp(word,start+len);
                if(after){
                    memo[start] = 1;
                    return true;
                }
            }
        }
        memo[start] = 0;
        return false;
    }


}
//leetcode submit region end(Prohibit modification and deletion)


}