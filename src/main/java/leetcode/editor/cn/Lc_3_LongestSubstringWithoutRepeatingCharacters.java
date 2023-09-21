package leetcode.editor.cn;


import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Lc_3_LongestSubstringWithoutRepeatingCharacters{
    public static void main(String[] args) {
    
        Solution solution = new Lc_3_LongestSubstringWithoutRepeatingCharacters()
                            .new Solution();
    }


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        // 滑动窗口
        int left = 0,right = 0;
        Set<Character> windows = new HashSet<>();
        int max = 0;
        while (right < s.length()){
            char c = s.charAt(right);
            // 增加窗口
            right++;
            while (!windows.add(c)){
                char d = s.charAt(left);
                windows.remove(d);
                left++;
            }
            // 统计
            max = Math.max(max,right-left);
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}