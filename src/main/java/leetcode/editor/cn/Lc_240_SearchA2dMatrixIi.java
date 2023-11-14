package leetcode.editor.cn;


public class Lc_240_SearchA2dMatrixIi{
    
    public static void main(String[] args) {
    
        Solution solution = new Lc_240_SearchA2dMatrixIi()
        .new Solution();
    }


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private boolean found;
    private int m;
    private int n;
    public boolean searchMatrix(int[][] matrix, int target) {
        m = matrix.length;
        n = matrix[0].length;
        find(matrix,0,n-1,target);
        return found;
    }

    public void find(int[][] matrix,int i,int j, int target) {
        if(i >= m || j < 0){
            return;
        }
        if(found)return;

        if(matrix[i][j] == target){
            found = true;
            return;
        }else if(matrix[i][j] > target){
            find(matrix,i,j-1,target);
        }else {
            find(matrix,i+1,j,target);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}