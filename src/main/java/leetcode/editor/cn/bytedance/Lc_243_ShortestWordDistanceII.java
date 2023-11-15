package leetcode.editor.cn.bytedance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @ClassName Lc_243_ShortestWordDistanceII
 * @Description TODO
 * @Author xuyubin6
 * @Date 2023/11/15 17:50
 */
public class Lc_243_ShortestWordDistanceII {

    public static void main(String[] args) {

    }


    class Solution{

        /**
         * 请设计一个类，使该类的构造函数能够接收一个单词列表。然后再实现一个方法，
         * 该方法能够分别接收两个单词 word1 和 word2，
         * 并返回列表中这两个单词之间的最短距离。您的方法将被以不同的参数调用 多次。
         */
        /**示例:
         假设 words = ["practice", "makes", "perfect", "coding", "makes"]

         输入: word1 = “coding”, word2 = “practice”
         输出: 3
         输入: word1 = "makes", word2 = "coding"
         输出: 1
         */
        HashMap<String, List<Integer>> map = new HashMap<String, List<Integer>>();

        public void  WordDistance(String[] words) {
            // 统计每个单词出现的下标存入哈希表中
            for(int i = 0; i < words.length; i++){
                List<Integer> cnt = map.get(words[i]);
                if(cnt == null){
                    cnt = new ArrayList<Integer>();
                }
                cnt.add(i);
                map.put(words[i], cnt);
            }
        }

        public int shortest(String word1, String word2) {
            List<Integer> idx1 = map.get(word1);
            List<Integer> idx2 = map.get(word2);
            int distance = Integer.MAX_VALUE;
            int i = 0, j = 0;
            // 每次比较两个下标列表最小的下标，然后把跳过较小的那个
            while(i < idx1.size() && j < idx2.size()){
                distance = Math.min(Math.abs(idx1.get(i) - idx2.get(j)), distance);
                if(idx1.get(i) < idx2.get(j)){
                    i++;
                } else {
                    j++;
                }
            }
            return distance;
        }

    }
}
