package leetcode.editor.cn;


import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Lc_227_BasicCalculatorIi{
    public static void main(String[] args) {
    
        Solution solution = new Lc_227_BasicCalculatorIi()
                            .new Solution();
        String s = "3+2*2";
        solution.calculate(s);
    }


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int calculate(String s) {
        Map<Character,Integer> signLevel = new HashMap<>();
        signLevel.put('+',1);
        signLevel.put('-',1);
        signLevel.put('*',2);
        signLevel.put('/',2);
        Stack<Integer> num = new Stack<>();
        Stack<Character> sign = new Stack<>();
        int sum = 0;

        // 解题关键：运算符栈内运算符比当前运算符优先级高时，才运算
        for (char c : s.toCharArray()) {
            if(' ' == c) {
                continue;
            }
            if('0' <= c && c <= '9'){
                sum = sum*10 + c -'0';
            }else {
                while (!sign.isEmpty() && signLevel.get(sign.peek()) - signLevel.get(c) >= 0){
                    // 栈内运算符比当前运算符 大于或等于
                    int v1 = num.pop();
                    int v2 = num.pop();
                    char preSign = sign.pop();
                    if(preSign == '+'){
                        v2 += v1;
                    }else if (preSign == '-'){
                        v2 -= v1;
                    }else if(preSign == '*'){
                        v2*= v1;
                    }else {
                        v2/= v1;
                    }
                    num.push(v2);
                }
                // 进栈
                num.push(sum);
                sign.push(c);
                sum = 0;
            }
        }
        int target = 0;
        if (!sign.isEmpty()){
            int v1 = num.pop();
            int v2 = num.pop();
            char preSign = sign.pop();
            if(preSign == '+'){
                v2 += v1;
            }else if (preSign == '-'){
                v2 -= v1;
            }else if(preSign == '*'){
                v2*= v1;
            }else {
                v2/= v1;
            }
            target += v2;
        }
        return target;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}