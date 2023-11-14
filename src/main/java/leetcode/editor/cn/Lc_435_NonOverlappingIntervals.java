package leetcode.editor.cn;


import java.util.Arrays;
import java.util.Comparator;

public class Lc_435_NonOverlappingIntervals{
    public static void main(String[] args) {
    
        Solution solution = new Lc_435_NonOverlappingIntervals()
                            .new Solution();
    }


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        return n - intervalSchedule(intervals);
    }

    /**
     * 获取最多不重叠区间个数
     * @param intervals
     * @return
     */
    public int intervalSchedule(int[][] intervals){
        // 按照区间【start，end】的 end 排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        // 至少有一个不重叠区间
        int count = 1;
        int end = intervals[0][1];
        for (int i = 1;i < intervals.length;i++){
            int start = intervals[i][0];
            if(start >= end){
                // 找到下一个不重叠区间
                end = intervals[i][1];
                count++;
            }
        }
        return count;


    }
}
//leetcode submit region end(Prohibit modification and deletion)


}