package leetcode.editor.cn;


public class Lc_215_KthLargestElementInAnArray{
    
    public static void main(String[] args) {
    
        Solution solution = new Lc_215_KthLargestElementInAnArray()
        .new Solution();
    }


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        int length = nums.length;
        sort(nums,0, length -1,length-k);

        return nums[length-k];
    }

    private void sort(int[] nums,int start,int end,int k){
        if(start < 0 || end >= nums.length){
            return;
        }
        int pivot = quick_sorted(nums, start, end);
        if(pivot == k){
            return;
        }
        if(pivot > k){
            sort(nums,start,pivot-1,k);
        }else {
            sort(nums,pivot+1,end,k);
        }
    }

    private int quick_sorted(int[] nums,int start,int end){
        // 排序的数
        int pivot = nums[start];

        int left = start+1;
        int right = end;
        while (left <= right){
            // 找到第一个大于pivot的
            while (left <= right && nums[left] <= pivot){
                left++;
            }
            // 找到第一个小于pivot
            while (left <= right && nums[right] > pivot){
                right--;
            }
            if(left > right){
                break;
            }else {
                swap(nums,left,right);
            }
        }
        swap(nums,start,right);
        return right;

    }

    private void swap(int[] nums,int p,int q){
        int tmp = nums[p];
        nums[p] = nums[q];
        nums[q] = tmp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}