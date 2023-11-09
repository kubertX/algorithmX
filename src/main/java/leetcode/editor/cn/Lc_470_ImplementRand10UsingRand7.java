package leetcode.editor.cn;


public class Lc_470_ImplementRand10UsingRand7{
    public static void main(String[] args) {
    
        Solution solution = new Lc_470_ImplementRand10UsingRand7()
                            .new Solution();
    }


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * The rand7() API is already defined in the parent class SolBase.
 * public int rand7();
 * @return a random integer in the range 1 to 7
 */
class Solution extends SolBase {
    public int rand10() {
        // (randX()-1)*Y + randY() = [1,X*Y]
        while (true){
            int a = rand7();
            int b = rand7();
            int num = (a-1)*7+b; //rand49
            if(num <= 40){
                return num%10+1;
            }

            // 减少拒绝采样
            a = num -40; //rand 9
            b = rand7();
            num = (a-1)*7+b;//rand63
            if(num <= 60){
                return num%10+1;
            }

            a = num-60;//rand3
            b = rand7();
            num = (a-1)*7+b;//rand21
            if(num <= 20)return num%10+1;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}