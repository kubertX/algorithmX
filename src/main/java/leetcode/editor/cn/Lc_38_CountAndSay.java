package leetcode.editor.cn;


public class Lc_38_CountAndSay{
    public static void main(String[] args) {
    
        Solution solution = new Lc_38_CountAndSay()
                            .new Solution();
    }


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String countAndSay(int n) {
        // base case S(i) = count(S(i-1)) = count(count(S(i-2)))...
        String pre = "1";
        for (int i = 2;i <= n;i++){
            int left = 0;
            int right = 0;
            StringBuilder sb = new StringBuilder();
            while (right < pre.length()){
                while (right < pre.length() && pre.charAt(left) == pre.charAt(right)){
                    right++;
                }
                sb.append(right-left).append(pre.charAt(left));
                left = right;
            }
            pre = sb.toString();

        }
        return pre;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}