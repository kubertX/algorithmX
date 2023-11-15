package leetcode.editor.cn;


public class Lc_88_MergeSortedArray{
    public static void main(String[] args) {
    
        Solution solution = new Lc_88_MergeSortedArray()
                            .new Solution();
        int[] a1 = {1, 2, 3, 0, 0, 0};
        int[] a2 = {2,5,6};
        solution.merge(a1,3,a2,3);
    }


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int[] tmp = new int[m];
        for (int i =0;i < m;i++){
            tmp[i] = nums1[i];
        }
        int p1 = 0,p2 = 0;
        int index = 0;
        while (p1 < m && p2 < n){
            int v1 = tmp[p1];
            int v2 = nums2[p2];
            if(v1 <= v2){
                nums1[index] = v1;
                p1++;
            }else {
                nums1[index] = v2;
                p2++;
            }
            index++;
        }
        if(p1 != m){
            for (int i = p1;i < m;i++,index++){
                nums1[index] = tmp[i];
            }
        }
        if(p2 != n){
            for (int i = p2;i < n;i++,index++){
                nums1[index] = nums2[i];
            }
        }
        return;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}