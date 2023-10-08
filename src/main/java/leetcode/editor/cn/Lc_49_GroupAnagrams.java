package leetcode.editor.cn;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Lc_49_GroupAnagrams{
    public static void main(String[] args) {
    
        Solution solution = new Lc_49_GroupAnagrams()
                            .new Solution();
    }


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> memo = new HashMap<>();
        for (String word : strs) {
            String code = encode(word);
            // System.out.println(code);
            List<String> list = memo.getOrDefault(code, new LinkedList<>());
            list.add(word);
            memo.put(code,list);
        }
        List<List<String>> ans = new LinkedList<>();
        for (String code : memo.keySet()) {
            ans.add(memo.get(code));
        }
        return ans;

    }

    private String encode(String word){
        char[] chars = new char[26];
        for (int i = 0;i<word.length();i++){
            chars[word.charAt(i)-'a'] ++;
        }
        return new String(chars);

    }
}
//leetcode submit region end(Prohibit modification and deletion)


}