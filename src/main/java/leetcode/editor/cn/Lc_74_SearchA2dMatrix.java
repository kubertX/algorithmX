package leetcode.editor.cn;


public class Lc_74_SearchA2dMatrix{
    public static void main(String[] args) {
    
        Solution solution = new Lc_74_SearchA2dMatrix()
                            .new Solution();
    }


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private int m;
    private int n;

    private boolean found;
    public boolean searchMatrix(int[][] matrix, int target) {
        this.m = matrix.length;
        this.n = matrix[0].length;
        search(matrix,0,n-1,target);
        return found;
    }

    // 从左上角开始搜索
    private void search(int[][] matrix,int i,int j,int target){
        if(i >= m || j < 0){
            // 角标越界
            return;
        }
        if(found){
            return;
        }

        if(matrix[i][j] == target){
            found = true;
            return;
        }else if(matrix[i][j] > target){
            // 左边找
            search(matrix,i,j-1,target);
        }else {
            // 往下找
            search(matrix,i+1,j,target);
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)


}