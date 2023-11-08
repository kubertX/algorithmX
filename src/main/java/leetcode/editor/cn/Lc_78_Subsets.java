package leetcode.editor.cn;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Lc_78_Subsets{
    public static void main(String[] args) {
    
        Solution solution = new Lc_78_Subsets()
                            .new Solution();
    }


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private List<List<Integer>> ans  = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();

    boolean[] used ;
    boolean[] visited;
    public List<List<Integer>> subsets(int[] nums) {
        used = new boolean[nums.length];
        backTrack(nums,0);
        return ans;
    }


    private void backTrack(int[] nums,int start){
        ans.add(new LinkedList<>(path));
        if(start == nums.length)return;

        for (int i = start;i < nums.length;i++ ){
            if(used[i]){
                continue;
            }
            used[i] = true;
            path.add(nums[i]);
            // 控制start 来控制避免产生重复的子集
            backTrack(nums,i+1);
            path.remove(path.size()-1);
            used[i] = false;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}