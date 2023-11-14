package leetcode.editor.cn;


import java.util.Arrays;
import java.util.Comparator;

public class Lc_452_MinimumNumberOfArrowsToBurstBalloons{
    
    public static void main(String[] args) {
    
        Solution solution = new Lc_452_MinimumNumberOfArrowsToBurstBalloons()
        .new Solution();
    }


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findMinArrowShots(int[][] points) {

        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] >= o2[1] ? 1 : -1;
            }
        });

        int count = 1;
        int index = points[0][1];
        for (int[] point : points) {
            int start = point[0];
            if(start > index){
                // 未命中重叠区间
                index = point[1];
                count++;
            }
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}