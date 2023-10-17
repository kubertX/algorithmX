package leetcode.editor.cn;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lc_LCR015_VabMRr{
    public static void main(String[] args) {
    
        Solution solution = new Lc_LCR015_VabMRr()
                            .new Solution();
        String s = "cbaebabacd";
        String p = "abc";
        solution.findAnagrams(s,p);
    }


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character,Integer> need = new HashMap<>();
        Map<Character,Integer> windows = new HashMap<>();
        for (char c : p.toCharArray()) {
            Integer count = need.getOrDefault(c, 0);
            need.put(c,count+1);
        }
        List<Integer> ans = new ArrayList<>();
        // 统计key的完成数量
        int finish = 0;
        int left = 0,right = 0;
        while (right < s.length()){
            char c = s.charAt(right);
            // 添加进穿窗口
            windows.put(c,windows.getOrDefault(c,0)+1);
            if(need.containsKey(c)){
                if (windows.get(c).equals(need.get(c))){
                    finish++;
                }
            }
            right++;
            // 缩小窗口
            if(right-left == p.length()){
                if(finish == need.keySet().size()){
                    ans.add(left);
                }
                char d = s.charAt(left);
                Integer count = windows.get(d);
                if(need.containsKey(d)){
                    if(need.get(d).equals(count)){
                        finish--;
                    }
                }
                windows.put(d,count-1);
                left++;
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}