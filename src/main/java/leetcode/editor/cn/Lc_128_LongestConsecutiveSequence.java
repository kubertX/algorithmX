package leetcode.editor.cn;


import java.util.HashSet;
import java.util.Set;

public class Lc_128_LongestConsecutiveSequence{
    
    public static void main(String[] args) {
    
        Solution solution = new Lc_128_LongestConsecutiveSequence()
        .new Solution();
    }


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestConsecutive(int[] nums) {
        //
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int max = 0;
        for (Integer num : set) {
            // 存在 num -1 ,说明当前num不是连续序列的起点
            if (set.contains(num-1)){
                continue;
            }
            int cur = num;
            int length = 1;
            while (set.contains(cur+1)){
                cur += 1;
                length += 1;
            }
            max = Math.max(max,length);
        }
        return max;


    }
}
//leetcode submit region end(Prohibit modification and deletion)


}