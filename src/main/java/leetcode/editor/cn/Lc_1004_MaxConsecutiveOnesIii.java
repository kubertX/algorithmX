package leetcode.editor.cn;


public class Lc_1004_MaxConsecutiveOnesIii{
    public static void main(String[] args) {
    
        Solution solution = new Lc_1004_MaxConsecutiveOnesIii()
                            .new Solution();
    }


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestOnes(int[] nums, int k) {
        // 题意转换为：找出一个最长子数组，最多包括k个0
        // 滑动窗口
        int left = 0;
        int right = 0;
        int windows = 0;
        int max = 0;
        while (right < nums.length){
            int val = nums[right];
            if(val == 0){
                windows++;
            }

            right++;
            if(windows <= k){
                max = Math.max(max,right-left);
            }else {
                while (left < right && windows > k){
                    // 缩小窗口
                    int remove = nums[left];
                    if(remove == 0){
                        windows--;
                    }
                    left++;
                }
            }
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}