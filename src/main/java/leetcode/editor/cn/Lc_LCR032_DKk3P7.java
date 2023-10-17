package leetcode.editor.cn;


public class Lc_LCR032_DKk3P7{
    public static void main(String[] args) {
    
        Solution solution = new Lc_LCR032_DKk3P7()
                            .new Solution();
    }


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        if(s.equals(t)){
            return false;
        }
        String s1 = encode(s);
        String s2 = encode(t);
        return s1.equals(s2);

    }

    private String encode(String word){
        char[] code = new char[26];
        for (char c : word.toCharArray()) {
            code[c-'a']++;
        }
        return new String(code);
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}