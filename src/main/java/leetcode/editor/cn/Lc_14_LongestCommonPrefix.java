package leetcode.editor.cn;


public class Lc_14_LongestCommonPrefix{
    
    public static void main(String[] args) {
    
        Solution solution = new Lc_14_LongestCommonPrefix()
        .new Solution();
    }


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestCommonPrefix(String[] strs) {
        //
        String prefix = strs[0];

        for (int j = 1;j < strs.length;j++){
            prefix = longestCommonPrefix(prefix,strs[j]);
            if(prefix.length() == 0){
                break;
            }
        }
        return prefix;

    }

    private String longestCommonPrefix(String prefix,String common){
        int length = Math.min(prefix.length(),common.length());
        int index = 0;
        while (index < length && prefix.charAt(index) == common.charAt(index)){
            index++;
        }
        return prefix.substring(0,index);
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}