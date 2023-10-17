package leetcode.editor.cn;


import java.util.HashSet;
import java.util.Set;

public class Lc_LCR186_BuKePaiZhongDeShunZiLcof{
    public static void main(String[] args) {
    
        Solution solution = new Lc_LCR186_BuKePaiZhongDeShunZiLcof()
                            .new Solution();
    }


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkDynasty(int[] places) {
        Set<Integer> set = new HashSet<>();
        int max = 0;
        int min = 14;
        for (Integer cur : places) {
            // 0 跳过
            if(cur == 0)continue;
            //
            max = Math.max(max,cur);
            min = Math.min(min,cur);
            if(set.contains(cur)){
                // 出现重复年代
                return false;
            }
            set.add(cur);
        }
        return max - min < 5;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}