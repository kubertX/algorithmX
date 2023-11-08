package leetcode.editor.cn;


public class Lc_33_SearchInRotatedSortedArray{
    public static void main(String[] args) {
    
        Solution solution = new Lc_33_SearchInRotatedSortedArray()
                            .new Solution();
    }


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int search(int[] nums, int target) {
        // 旋转数组，右边保持升序
        int left = 0;
        int right = nums.length-1;
        // 搜索区间 [left,right]
        while (left <= right){
            int mid = left + (right-left)/2;
            if(nums[mid] == target){
                return mid;
            }
            // 判断 左右哪边有序, = 的情况是考虑，left和mid角标相等
            if(nums[left] <= nums[mid]){
                // 左边有序，
                if(nums[left] <= target && target < nums[mid]){
                    // target 落在左间，下一个搜索区间[left,mid-1]
                    right = mid-1;
                }else {
                    // target 落在右边，下一个搜索区间[mid+1,right]
                    left = mid + 1;
                }
            }else {
                // 右边有序
                if(nums[mid] < target && target <= nums[right]){
                    // target 在右边，下一个区间[mid+1,right]
                    left = mid + 1;
                }else {
                    // target 在左边，下一个[left,mid-1]
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}