package leetcode.editor.cn;
//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
//
// 示例: 
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
// Related Topics 回溯算法 
// 👍 366 👎 0


import java.util.ArrayList;
import java.util.List;

/**
 * 20200908提交 未学习
 */
public class Combinations{
    public static void main(String[] args){
        Solution solution = new Combinations().new Solution();
        solution.combine(4,2);
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<Integer> temp = new ArrayList<Integer>();
    List<List<Integer>> result = new ArrayList<List<Integer>>();

    public List<List<Integer>> combine(int n, int k) {

        dfs(1, n, k);
        return result;
    }

    public void dfs(int cur, int n, int k) {
        // 剪枝：temp 长度加上区间 [cur, n] 的长度小于 k，不可能构造出长度为 k 的 temp
        if (temp.size() + (n - cur + 1) < k) {
            return;
        }
        // 记录合法的答案
        if (temp.size() == k) {
            result.add(new ArrayList<Integer>(temp));
            return;
        }
        // 考虑选择当前位置
        temp.add(cur);
        dfs(cur + 1, n, k);
        temp.remove(temp.size() - 1);
        // 考虑不选择当前位置
        dfs(cur + 1, n, k);
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}