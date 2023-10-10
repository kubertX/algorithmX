package leetcode.editor.cn;


public class Lc_200_NumberOfIslands{
    public static void main(String[] args) {
    
        Solution solution = new Lc_200_NumberOfIslands()
                            .new Solution();
    }


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    int length;
    int high;
    public int numIslands(char[][] grid) {
        //
        this.high = grid.length;
        this.length = grid[0].length;
        int ans = 0;
        for (int i = 0;i < high;i++ ) {
            for (int j = 0;j < length;j++){
                if(grid[i][j] == '0'){
                    continue;
                }
                ans ++;
                dfs(grid,i,j);
            }
        }
        return ans;
    }

    private void dfs(char[][] grid,int i,int j){
        if(i < 0 || i >= high || j < 0 || j >= length){
            // 角标越界
            return;
        }
        if(grid[i][j] == '0'){
            // 碰到海水
            return;
        }
        // 将当前面积淹没
        grid[i][j] = '0';
        // 上下左右蔓延
        dfs(grid,i-1,j);
        dfs(grid,i+1,j);
        dfs(grid,i,j-1);
        dfs(grid,i,j+1);


    }
}
//leetcode submit region end(Prohibit modification and deletion)


}