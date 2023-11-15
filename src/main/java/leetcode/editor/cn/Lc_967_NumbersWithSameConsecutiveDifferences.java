package leetcode.editor.cn;


import java.util.LinkedList;
import java.util.List;

public class Lc_967_NumbersWithSameConsecutiveDifferences{
    
    public static void main(String[] args) {
    
        Solution solution = new Lc_967_NumbersWithSameConsecutiveDifferences()
        .new Solution();
    }


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private StringBuilder sb = new StringBuilder();
    private List<Integer> ans = new LinkedList<>();
    public int[] numsSameConsecDiff(int n, int k) {
        for (int i = 1;i<=9;i++){
            sb.append(i);
            dfs(n,k,0);
            sb.deleteCharAt(sb.length()-1);
        }
        int[] res = new int[ans.size()];
        for (int i = 0;i < ans.size();i++){
            res[i] = ans.get(i);
        }
        return res;
    }

    private void dfs(int length,int target,int preIndex){
        if(preIndex == length-1){
            ans.add(Integer.valueOf(sb.toString()));
            return;
        }

        for (int i = 0;i<= 9;i++){
            if(Math.abs(sb.charAt(preIndex)-'0'-i) == target){
                sb.append(i);
                dfs(length,target,preIndex+1);
                sb.deleteCharAt(sb.length()-1);
            }
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)


}