package leetcode.editor.cn;


import java.util.TreeSet;

public class Lc_414_ThirdMaximumNumber{
    public static void main(String[] args) {
    
        Solution solution = new Lc_414_ThirdMaximumNumber()
                            .new Solution();
    }


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int thirdMax(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int num : nums) {
            set.add(num);
            if(set.size() > 3){
                set.remove(set.first());
            }
        }
        return set.size() == 3? set.first():set.last();
    }


}
//leetcode submit region end(Prohibit modification and deletion)


}