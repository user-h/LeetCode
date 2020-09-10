package leetcode.sword.offer;
//一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
//
// 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。 
//
// 示例 1： 
//
// 输入：n = 2
//输出：2
// 
//
// 示例 2： 
//
// 输入：n = 7
//输出：21
// 
//
// 示例 3： 
//
// 输入：n = 0
//输出：1 
//
// 提示： 
//
// 
// 0 <= n <= 100 
// 
//
// 注意：本题与主站 70 题相同：https://leetcode-cn.com/problems/climbing-stairs/ 
//
// 
// Related Topics 递归 
// 👍 65 👎 0

/**
 * 同上一个题20200908
 */
public class QingWaTiaoTaiJieWenTiLcof{
    public static void main(String[] args){
        Solution solution = new QingWaTiaoTaiJieWenTiLcof().new Solution();
        System.out.println(solution.numWays(12));
    }
//leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    /**
     * 即为斐波那契数列
     * 0 => 1
     * 1 => 1
     * 2 => 11,     2
     * 3 => 111,    12,     21
     * 4 => 1111,   112,    121,    211,    22,
     * 5 => 11111,  1112,   1121,   1211,   122,    2111,   212,    221
     * 6 => 111111, 11112,  11121,  11211,  1122,   12111,  1212,   1221,  21111, 2112, 2112, 2121, 2211, 222
     */
    public int numWays(int n) {
        int fn = 1, fn1 = 1, sum;
        for (int i = 0; i < n; i++) {
            sum = (fn + fn1) % 1000000007;
            fn = fn1;
            fn1 = sum;
        }
        return fn;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}