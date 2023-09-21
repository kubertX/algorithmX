package leetcode.editor.cn;


import java.util.HashMap;
import java.util.Map;

public class Lc_1_TwoSum{
    public static void main(String[] args) {
    
        Solution solution = new Lc_1_TwoSum()
                            .new Solution();
    }


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] twoSum(int[] nums, int target) {

        int[] res = new int[2];
        Map<Integer,Integer> memo = new HashMap<>();
        for(int i = 0;i < nums.length;i++){
            if(memo.containsKey(target-nums[i])){
                res[0] = memo.get(target-nums[i]);
                res[1] = i;
                return res;
            }
            memo.put(nums[i],i);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}