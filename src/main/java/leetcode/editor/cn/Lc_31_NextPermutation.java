package leetcode.editor.cn;


public class Lc_31_NextPermutation{
    public static void main(String[] args) {
    
        Solution solution = new Lc_31_NextPermutation()
                            .new Solution();
    }


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void nextPermutation(int[] nums) {

        // 1. 后往前，找到第一对 相邻元素是升序的元素对 (i,i+1)
        // 即num[i] < nums[i+1]
        int pos = -1;
        for (int i = nums.length-1; i >= 1;i--){
            if(nums[i-1] < nums[i]){
                pos = i -1;
                break;
            }
        }
        // 1.1没找到升序对，说明当前数组是降序
        // 直接返回 数组反转为升序
        if (pos == -1){
            reverse(nums,0);
            return;
        }

        // 2. 后往前遍历，[i+1,end] 找到第一个 大于 nums[j] > nums[i] 的元素
        int j = nums.length-1;
        for (; j >= pos+1;j--){
            if(nums[j] > nums[pos]){
                break;
            }
        }

        // 3. 交换 i,j 元素
        swap(nums,pos,j);
        // 4. 反转 [i+1,end] 区间的元素
        reverse(nums,pos+1);

    }

    private void reverse(int[] nums,int start){
        int i = start;
        int j = nums.length-1;
        while (i < j && i < nums.length && j > 0){
            swap(nums,i,j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums,int i,int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}