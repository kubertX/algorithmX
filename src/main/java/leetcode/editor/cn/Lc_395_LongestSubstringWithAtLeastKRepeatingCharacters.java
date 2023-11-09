package leetcode.editor.cn;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Lc_395_LongestSubstringWithAtLeastKRepeatingCharacters{
    public static void main(String[] args) {
    
        Solution solution = new Lc_395_LongestSubstringWithAtLeastKRepeatingCharacters()
                            .new Solution();
    }


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        /**为了方便记输入字串为 s，其长度为 n，个数要求为 k:

         先处理一些特例，k如果是1，答案就是n
         k如果大于n，是无解的
         统计 s中的字符个数，因只有英文小写字母，所以长26的整数数组就可以
         找到字符个数小于k的那个，用这个字符，把 s分隔为几个部分，递归处理每个部分
         这几个部分的最大长度就是答案
         如果，没有找到计数小于kkk的字符，说明整个 s是符合要求的，返回nnn
        */
    public int longestSubstring(String s, int k) {
        // 分治算法
        int n = s.length();
        if(k==1){
            return n;
        }
        if( k > n){
            return 0;
        }
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c-'a']++;
        }

        // 寻找小于k 的字符
        for (int i = 0;i < 26;i++) {
            if(count[i] >0 && count[i] < k){
                char spiltChar = (char) ('a'+i);
                int res = 0;
                for (String sub:s.split(String.valueOf(spiltChar))){
                    res = Math.max(res,longestSubstring(sub,k));
                }
                return res;

            }
        }
        // 没有找到小于k的字符，说明整个字符串都符合
        return n;

    }
}
//leetcode submit region end(Prohibit modification and deletion)


}