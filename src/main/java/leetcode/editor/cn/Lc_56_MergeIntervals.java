package leetcode.editor.cn;


import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Lc_56_MergeIntervals{
    
    public static void main(String[] args) {
    
        Solution solution = new Lc_56_MergeIntervals()
        .new Solution();
    }


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]){
                    return o1[1] >= o2[1] ? -1:1;
                }
                return o1[0] > o2[0] ? 1: -1;
            }
        });

        List<int[]> ans = new LinkedList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int[] interval : intervals) {
            int p1 = interval[0];
            int p2 = interval[1];
            if(p1 > end){
                // 碰到下一个不能合并区间
                ans.add(new int[]{start,end});
                start = p1;
                end = p2;
            }else {
                // 合并区间
                start = Math.min(start,p1);
                end = Math.max(end,p2);
            }
        }
        ans.add(new int[]{start,end});
        int[][] res = new int[ans.size()][2];
        for (int i = 0;i < ans.size();i++){
            res[i] = ans.get(i);
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}