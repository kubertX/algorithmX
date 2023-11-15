package leetcode.editor.cn;


import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Lc_227_BasicCalculatorIi{
    public static void main(String[] args) {
    
        Solution solution = new Lc_227_BasicCalculatorIi()
                            .new Solution();
        String s = " 3/2 ";
        solution.calculate(s);
    }


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char sign = '+';
        for (int i =0;i < s.length();i++){
            char c = s.charAt(i);
            // 当前字符是数字字符
            if(Character.isDigit(c)){
                num = num*10 + (c - '0');
            }
            // 非数字 或者 到达最后一个字符，运算后进栈
            if((!Character.isDigit(c) && c != ' ' )|| i == s.length()-1){
                // 计算上一个字符运算情况
                // + - 字符直接进栈，乘除 取出前一个数字 计算后进栈
                if(sign == '+'){
                    stack.push(num);
                }else if(sign == '-'){
                    stack.push(-num);
                }else if(sign == '*'){
                    int pre = stack.pop();
                    stack.push(pre * num);
                }else if(sign == '/'){
                    int pre = stack.pop();
                    stack.push(pre/num);
                }

                //
                sign = c;
                num = 0;
            }
        }
        int res = 0;
        while (!stack.isEmpty()){
            res += stack.pop();
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}