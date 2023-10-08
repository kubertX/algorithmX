package leetcode.editor.cn;


import java.util.Deque;
import java.util.LinkedList;

public class Lc_394_DecodeString{
    public static void main(String[] args) {
    
        Solution solution = new Lc_394_DecodeString()
                            .new Solution();
    }


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        Deque<Integer> stack_multi = new LinkedList<>();
        Deque<String> stack_res = new LinkedList<>();
        int multi = 0;
        for(char c: s.toCharArray()){
            if(c == '['){
                // 入栈
                stack_multi.push(multi);
                stack_res.push(res.toString());
                multi = 0;
                res = new StringBuilder();
            }else if(c == ']'){
                // 出栈
                int cur_multi = stack_multi.poll();
                String last_res = stack_res.poll();
                StringBuilder tmp = new StringBuilder();
                for (int i =0;i < cur_multi;i++){
                    tmp.append(res);
                }
                res = new StringBuilder(last_res + tmp);

            }else if('0' <= c && c <= '9'){
                // 可能出现大于10的数字，更新multi
                multi = (multi*10) + (c -'0');
            }else {
                // 更新 res
                res.append(c);
            }
        }
        return res.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}