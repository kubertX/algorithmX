package leetcode.editor.cn;


import javafx.beans.binding.When;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Lc_15_ThreeSum{
    public static void main(String[] args) {
    
        Solution solution = new Lc_15_ThreeSum()
                            .new Solution();
    }


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {



    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        return threeSum(nums,0);

    }

    public List<List<Integer>> threeSum(int[] nums,int target){
        List<List<Integer>> ans = new LinkedList<>();
        for (int i = 0;i < nums.length;i++){
            List<List<Integer>> path = twoSum(nums, i + 1, nums[i], target - nums[i]);
            if(path != null && !path.isEmpty()){
                ans.addAll(path);
            }
            while (i < nums.length-1 && nums[i] == nums[i+1]){
                i++;
            }
        }
        return ans;
    }

    public List<List<Integer>> twoSum(int[] nums,int start,int curVal,int target){
       List<List<Integer>> ans = new LinkedList<>();
       int lo = start;
       int hi = nums.length-1;
       while (lo < hi){
           int left = nums[lo];
           int right = nums[hi];
           int sum = left + right;
           if(sum < target){
               while (lo < hi && nums[lo] == left){lo++;}
           }else if(sum > target){
               while (lo < hi && nums[hi] == right){hi--;}
           }else {
               List<Integer> path = new LinkedList<>();
               path.add(curVal);
               path.add(left);
               path.add(right);
               ans.add(path);
               while (lo < hi && nums[lo] == left){lo++;}
               while (lo < hi && nums[hi] == right){hi--;}
           }
       }
       return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}