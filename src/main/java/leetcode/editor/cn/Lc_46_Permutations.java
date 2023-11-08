package leetcode.editor.cn;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Lc_46_Permutations{
    public static void main(String[] args) {
    
        Solution solution = new Lc_46_Permutations()
                            .new Solution();
    }


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private List<List<Integer>> ans = new ArrayList<>();

    private List<Integer> path = new ArrayList<>();

    private boolean[] used;
    public List<List<Integer>> permute(int[] nums) {
        used = new boolean[nums.length];
        backTrack(nums);
        return ans;
    }

    private void backTrack(int[] nums){
        if(path.size() == nums.length){
            ans.add(new LinkedList<>(path));
        }
        for (int i = 0;i < nums.length;i++){
            if(used[i]){
                continue;
            }
            used[i] = true;
            path.add(nums[i]);
            backTrack(nums);
            path.remove(path.size()-1);
            used[i]= false;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}