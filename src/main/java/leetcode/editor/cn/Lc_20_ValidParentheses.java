package leetcode.editor.cn;


public class Lc_20_ValidParentheses{
    public static void main(String[] args) {
    
        Solution solution = new Lc_20_ValidParentheses()
                            .new Solution();
    }


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {
        // 记录当前最左的 左边界类型括号
        char[] left = new char[s.length()];
        int index = -1;
        for (int i = 0;i< s.length();i++){
            char c = s.charAt(i);
            if(c == '[' || c == '{' || c == '('){
                index++;
                left[index] = c;
            }else {
                if(index != -1 && getLeftChar(c) == left[index]){
                    index--;
                }else {
                    return false;
                }
            }
        }

        return index == -1;

    }

    private char getLeftChar(char c) {
        if(c == ']'){
            return '[' ;
        }else if(c == '}'){
            return '{';
        }else {
            return '(';
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}