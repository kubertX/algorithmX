package leetcode.editor.cn;


public class Lc_11_ContainerWithMostWater{
    public static void main(String[] args) {
    
        Solution solution = new Lc_11_ContainerWithMostWater()
                            .new Solution();
    }


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxArea(int[] height) {
        // 双指针
        // 计算
        // 比较当前左右2个高度，移动 高度低的 一边
        // 面积 = min(height[left],height[right]) * (right-left)
        int left = 0;
        int right = height.length-1;
        // 当前最大面积
        int res = 0;
        while (left < right){
            int curArea = Math.min(height[left],height[right]) * (right-left);
            res = Math.max(res,curArea);
            if(height[left] < height[right]){
                left++;
            }else {
                right--;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}