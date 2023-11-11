package leetcode.editor.cn;


import java.security.Key;

public class Lc_695_MaxAreaOfIsland{
    
    public static void main(String[] args) {
    
        Solution solution = new Lc_695_MaxAreaOfIsland()
        .new Solution();
    }


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private int area;
    public int maxAreaOfIsland(int[][] grid) {

        int max = 0;
        for (int i = 0;i < grid.length;i++){
            for (int j = 0;j < grid[0].length;j++){
                if(grid[i][j] == 0){
                    continue;
                }
                area = 0;
                dfs(grid,i,j);
                max = Math.max(max,area);
            }
        }
        return max;
    }

    public void dfs(int[][] grid,int i,int j){
        if(i >= grid.length || i < 0 || j >= grid[0].length || j< 0 ){
            return;
        }

        if(grid[i][j] == 0){
            return;
        }
        // 淹没
        grid[i][j] = 0;
        area++;
        dfs(grid,i-1,j);
        dfs(grid,i+1,j);
        dfs(grid,i,j+1);
        dfs(grid,i,j-1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}