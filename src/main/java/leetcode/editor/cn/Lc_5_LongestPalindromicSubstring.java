package leetcode.editor.cn;


public class Lc_5_LongestPalindromicSubstring{
    public static void main(String[] args) {
    
        Solution solution = new Lc_5_LongestPalindromicSubstring()
                            .new Solution();
    }


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
        int max = 0;
        String ans = "";
        for (int i = 0;i< s.length();i++){
            // 当前为中心
            String s1 = longestPalindrome(s, i, i);
            if(s1.length() > max){
                ans = s1;
                max = s1.length();
            }
            // 左右为中心
            String s2 = longestPalindrome(s, i, i+1);
            if(s2.length() > max){
                ans = s2;
                max = s2.length();
            }
        }
        return ans;
    }

    private String longestPalindrome(String str,int left,int right){
        while (left >= 0 && right < str.length()
                && str.charAt(left) == str.charAt(right)){
            left--;
            right++;
        }
        return str.substring(left+1,right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}