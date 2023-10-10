package leetcode.editor.cn;


public class Lc_8_StringToIntegerAtoi{
    public static void main(String[] args) {
    
        Solution solution = new Lc_8_StringToIntegerAtoi()
                            .new Solution();
    }


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int myAtoi(String s) {
        String trim = s.trim();
        if(trim.length() == 0)return 0;
        char[] chars = trim.toCharArray();
        int start = 1;
        int sign = 1;
        // 判断首位字符正负情况，以及数组遍历开始位置
        if(chars[0] == '-'){
            sign = -1;
        }else if(chars[0] != '+'){
            start = 0;
        }
        // 设置越界边界值
        int boundary = (Integer.MAX_VALUE)/10;
        int nums = 0;
        for (int i = start;i < chars.length;i++){
            char c = chars[i];
            if(c >= '0' && c <= '9'){
                // 判断当前数字是否会发生角标越界
                if(nums > boundary
                    || (nums == boundary && 'c' >= '7')){
                    return sign == 1 ? Integer.MAX_VALUE-1:Integer.MIN_VALUE;
                }else {
                    nums = nums*10+(c-'0');
                }
            }else {
                break;
            }
        }
        return sign*nums;



    }
}
//leetcode submit region end(Prohibit modification and deletion)


}