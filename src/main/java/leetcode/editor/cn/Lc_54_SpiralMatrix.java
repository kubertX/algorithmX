package leetcode.editor.cn;


import java.util.LinkedList;
import java.util.List;

public class Lc_54_SpiralMatrix{
    public static void main(String[] args) {
    
        Solution solution = new Lc_54_SpiralMatrix()
                            .new Solution();
        int[][] ma = {{1,2,3},{4,5,6},{7,8,9}};
        solution.spiralOrder(ma);
    }


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;
        // 定义上下左右边界
        int up = 0,down = m -1,left = 0,right = n -1;
        int size = m*n;
        int index = 0;
        List<Integer> ans = new LinkedList<>();
        while (index < size){
            if(left <= right){
                for (int i = left; i <= right;i++){
                    ans.add(matrix[up][i]);
                    index++;
                }
                // 收缩上
                up++;
            }
            if(up <= down){
                for (int i = up;i <= down;i++){
                    ans.add(matrix[i][right]);
                    index++;
                }
                // 收缩右
                right--;
            }
            if(left <= right){
                for (int i = right;i >= left;i--){
                    ans.add(matrix[down][i]);
                    index++;
                }
                down--;
            }
            if(up <= down){
                for (int i = down;i >= up;i--){
                    ans.add(matrix[i][left]);
                    index++;
                }
                left++;
            }
        }
        return ans;
    }

}
//leetcode submit region end(Prohibit modification and deletion)


}