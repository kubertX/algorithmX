package leetcode.editor.cn;


public class Lc_Mst10_01_SortedMergeLcci{
    
    public static void main(String[] args) {
    
        Solution solution = new Lc_Mst10_01_SortedMergeLcci()
        .new Solution();
    }


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void merge(int[] A, int m, int[] B, int n) {
        int[] a1 = new int[m];
        for (int i = 0; i < m;i++) {
            a1[i] = A[i];
        }
        int[] a2 = B;
        int p1 = 0;
        int p2 = 0;
        int index = 0;
        while (p1 < m && p2 < n){
            int v1 = a1[p1];
            int v2 = a2[p2];
            if(v1 <= v2){
                A[index] = v1;
                p1++;
            }else {
                A[index] = v2;
                p2++;
            }
            index++;
        }
        if(p1 < m){
            for (int i = p1;i < m;i++){
                A[index] = a1[i];
                index++;
            }
        }
        if(p2 < n){
            for (int i = p2;i < n;i++){
                A[index] = a2[i];
                index++;
            }
        }
        return;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}