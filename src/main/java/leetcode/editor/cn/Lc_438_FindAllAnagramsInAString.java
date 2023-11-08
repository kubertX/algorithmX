package leetcode.editor.cn;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

public class Lc_438_FindAllAnagramsInAString{
    public static void main(String[] args) {
    
        Solution solution = new Lc_438_FindAllAnagramsInAString()
                            .new Solution();
    }


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character,Integer> need = new HashMap<>();
        for (char c : p.toCharArray()) {
            Integer count = need.getOrDefault(c, 0);
            need.put(c,count+1);
        }

        Map<Character,Integer> windows = new HashMap<>();
        int size = 0;
        List<Integer> ans = new LinkedList<>();
        int l = 0;
        int r = 0;
        while (r < s.length()){
            char c = s.charAt(r);
            windows.put(c,windows.getOrDefault(c,0)+1);
            if(need.containsKey(c)){
                if(windows.get(c).equals(need.get(c))){
                    size++;
                }
            }
            r++;
            if(r-l >= p.length()){
                if(size == need.size()){
                    ans.add(l);
                }
                // 缩小
                char d = s.charAt(l);
                if(need.containsKey(d)){
                    if(need.get(d).equals(windows.get(d))){
                        size--;
                    }
                }
                windows.put(d,windows.get(d)-1);
                l++;
            }
        }
        return ans;



    }
}
//leetcode submit region end(Prohibit modification and deletion)


}