package leetcode.editor.cn;


import java.util.LinkedList;
import java.util.List;

public class Lc_17_LetterCombinationsOfAPhoneNumber{
    public static void main(String[] args) {
    
        Solution solution = new Lc_17_LetterCombinationsOfAPhoneNumber()
                            .new Solution();
    }


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private  char[][] dict = {
            null,
            {'a','b','c'},
            {'d','e','f'},
            {'g','h','i'},
            {'j','k','l'},
            {'m','n','o'},
            {'p','q','r','s'},
            {'t','u','v'},
            {'w','x','y','z'}
    };

    private List<String> ans = new LinkedList<>();
    StringBuilder path = new StringBuilder();
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0){
            return ans;
        }
        dfs(digits,0);
        return ans;
    }

    private void dfs(String digits,int start){
        if(start == digits.length()){
            ans.add(path.toString());
            return;
        }
        char[] chars = dict[digits.charAt(start)-'1'];
        if(chars == null){return;}
        for (int i = 0; i< chars.length; i++){
            path.append(chars[i]);
            dfs(digits,start+1);
            path.deleteCharAt(path.length()-1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}