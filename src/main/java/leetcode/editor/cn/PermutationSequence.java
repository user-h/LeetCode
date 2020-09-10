package leetcode.editor.cn;
//给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
//
// 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下： 
//
// 
// "123"  1
// "132"  2
// "213"  3
// "231"  4
// "312"  5
// "321"  6
// 
//
// 给定 n 和 k，返回第 k 个排列。 
//
// 说明： 
//
// 
// 给定 n 的范围是 [1, 9]。 
// 给定 k 的范围是[1, n!]。 
// 
//
// 示例 1: 
//
// 输入: n = 3, k = 3
//输出: "213"
// 
//
// 示例 2: 
//
// 输入: n = 4, k = 9
//输出: "2314"
// 
// Related Topics 数学 回溯算法 
// 👍 356 👎 0


import java.util.Arrays;

public class PermutationSequence{
    public static void main(String[] args){
        Solution solution = new PermutationSequence().new Solution();
        System.out.println(solution.getPermutation(4, 9));
        //System.out.println(solution.getPermutation(3, 1));
        //System.out.println(solution.getPermutation(3, 6));

    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String getPermutation(int n, int k) {
        int[] factorial = new int[n];
        factorial[0] = 1;
        for (int i = 1; i < n; i++) {
            factorial[i] = factorial[i-1] * i;
            System.out.println(factorial[i]);
        }

        StringBuilder sb = new StringBuilder();

        --k;
        int[] valid = new int[n + 1];
        Arrays.fill(valid, 1);
        for (int i = 1; i <= n; ++i) {
            int order = k / factorial[n - i] + 1;
            for (int j = 1; j <= n; ++j) {
                order -= valid[j];
                if (order == 0) {
                    sb.append(j);
                    valid[j] = 0;
                    break;
                }
            }
            k %= factorial[n - i];
        }

        return sb.toString();
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}