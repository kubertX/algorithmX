package leetcode.editor.cn;


import java.util.*;

public class Lc_LCR033_Sfvd7V{
    public static void main(String[] args) {
    
        Solution solution = new Lc_LCR033_Sfvd7V()
                            .new Solution();
    }


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for (String str : strs) {
            String key = encode(str);
            List<String> list = map.getOrDefault(key, new LinkedList<>());
            list.add(str);
            map.put(key,list);
        }
        List<List<String>> ans = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            ans.add(entry.getValue());
        }
        return ans;
    }

    public String encode(String word){
        char[] encode = new char[26];
        for (char c : word.toCharArray()) {
            encode[c-'a']++;
        }
        return new String(encode);
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}