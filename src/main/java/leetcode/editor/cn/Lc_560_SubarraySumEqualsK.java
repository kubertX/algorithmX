package leetcode.editor.cn;


import java.util.HashMap;
import java.util.Map;

public class Lc_560_SubarraySumEqualsK{
    
    public static void main(String[] args) {
    
        Solution solution = new Lc_560_SubarraySumEqualsK()
        .new Solution();
    }


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> preSum = new HashMap<>();
        preSum.put(0,1);
        int sum = 0;
        int count = 0;
        for (int num : nums) {
            sum += num;
            if(preSum.containsKey(sum-k)){
                count+=preSum.get(sum-k);
            }
            preSum.put(sum,preSum.getOrDefault(sum,0)+1);
        }
        return count;


    }
}
//leetcode submit region end(Prohibit modification and deletion)


}