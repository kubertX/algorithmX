package leetcode.editor.cn;


import java.util.LinkedList;
import java.util.List;

public class Lc_22_GenerateParentheses{
    public static void main(String[] args) {
    
        Solution solution = new Lc_22_GenerateParentheses()
                            .new Solution();
    }


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    List<String> ans = new LinkedList<>();
    StringBuilder path = new StringBuilder();
    public List<String> generateParenthesis(int n) {
        backTrack(n,n);
        return ans;
    }

    private void backTrack(int left,int right){
        if(right < left){
            // 右括号剩余数量小于左括号剩余数量，不合法
            return;
        }
        if(left < 0 || right < 0){
            return;
        }
        if(left == 0 && right ==0){
            ans.add(path.toString());
            return;
        }

        // 选择左括号
        path.append('(');
        // 进行下一次选择
        backTrack(left-1,right);
        // 撤销选择左括号
        path.deleteCharAt(path.length()-1);

        // 选择右括号
        path.append(')');
        // 进行下一次选择
        backTrack(left,right-1);
        // 撤销选择左括号
        path.deleteCharAt(path.length()-1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}