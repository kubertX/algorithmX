package leetcode.editor.cn;


public class Lc_300_LongestIncreasingSubsequence{
    public static void main(String[] args) {
    
        Solution solution = new Lc_300_LongestIncreasingSubsequence()
                            .new Solution();
    }


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    /**
     *   10  5  7  101
     *   9   3
     *   2
     */
    public int lengthOfLIS(int[] nums) {


        int[] top = new int[nums.length];
        // 当前有几堆扑克堆
        int pieces = 0;
        for (int i = 0;i < nums.length;i++){
            int poke = nums[i];
            // 左到右遍历扑克堆，放在最左侧出现的第一个牌顶大于当前扑克的堆上
            int left = 0;
            int right = pieces;
            while (left < right){
                int mid = (left+right)/2;
                if(top[mid] < poke ){
                    left = mid+1;
                }else {
                    right = mid;
                }
            }
            if(left == pieces){
                // 没找到合适的牌堆，新增一个牌堆
                pieces++;
                top[pieces-1] = poke;
            }else {
                top[left] = poke;
            }
        }
        return pieces;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}