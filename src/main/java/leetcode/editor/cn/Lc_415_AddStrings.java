package leetcode.editor.cn;


public class Lc_415_AddStrings{
    public static void main(String[] args) {
    
        Solution solution = new Lc_415_AddStrings()
                            .new Solution();
    }


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String addStrings(String num1, String num2) {

        int r1 = num1.length()-1;
        int r2 = num2.length()-1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        int a = 0;
        int b = 0;
        int num = 0;
        while (r1 >= 0 || r2 >= 0 || carry > 0){
            a = r1 >= 0 ? num1.charAt(r1) - '0' : 0;
            b = r2 >= 0 ? num2.charAt(r2) - '0' : 0;
            num = a + b + carry;
            sb.append(num%10);
            carry = num/10;
            r1 --;
            r2 --;
        }
        return sb.reverse().toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}