package leetcode.editor.cn;


public class Lc_Mst01_03_StringToUrlLcci{
    public static void main(String[] args) {
    
        Solution solution = new Lc_Mst01_03_StringToUrlLcci()
                            .new Solution();
    }


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String replaceSpaces(String S, int length) {
        StringBuilder sb = new StringBuilder();
        int left = 0;
        while (left < length){
            char c = S.charAt(left);
            if(c == ' '){
                sb.append("%20");
            }else {
                sb.append(c);
            }
            left++;
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}