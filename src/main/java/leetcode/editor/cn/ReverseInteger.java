package leetcode.editor.cn;
//给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
//
// 示例 1: 
//
// 输入: 123
//输出: 321
// 
//
// 示例 2: 
//
// 输入: -123
//输出: -321
// 
//
// 示例 3: 
//
// 输入: 120
//输出: 21
// 
//
// 注意: 
//
// 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231, 231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。 
// Related Topics 数学 
// 👍 2154 👎 0


public class ReverseInteger{
    public static void main(String[] args){
        Solution solution = new ReverseInteger().new Solution();
        System.out.println(solution.reverse(-2147483648));
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int reverse(int x) {
        return reverse2(x);
    }

    /**
     * 2.学习另一个方法 以-2147483648为例子
     */
    public int reverse2(int x) {
        // System.out.println(-846384741 * 10 / 10);   // 12608718
        int ans = 0;
        while (x != 0) {
            if ((ans * 10) / 10 != ans) {       // -846384741 * 10 (会自动转换为long???) 溢出
                ans = 0;
                break;
            }
            ans = ans * 10 + x % 10;
            x = x / 10;
        }
        return ans;
    }

    /**
     * 1.官方解法
     * ????同样的代码为什么放到另一个方法里 执行时间差距这么大
     * 17:32	info
     * 			解答成功:
     * 			执行耗时:2 ms,击败了35.32% 的Java用户
     * 			内存消耗:37.3 MB,击败了16.16% 的Java用户
     *
     *
     * 17:34	info: 已提交,请稍等
     *
     * 17:35	info
     * 			解答成功:
     * 			执行耗时:1 ms,击败了100.00% 的Java用户
     * 			内存消耗:37.2 MB,击败了23.91% 的Java用户
     */
    public int reverse1(int x) {
        //System.out.println(Integer.MAX_VALUE);
        //System.out.println(Integer.MIN_VALUE);
        int result = 0;
        int pop;
        while (x != 0) {
            pop = x % 10;   // 取出原数值最后一位
            x = x / 10;         // 原数值去掉最后一位

            // 判断是否溢出
            // [Integer.MAX_VALUE/10 = 2147483647/10] [Integer.MIN_VALUE/10 = -2147483648/10]
            // 当 1.result > 214748364时 2.result=214748364且最后一位>7时 溢出
            if (result > 214748364 || (result == 214748364 && pop > 7)) return 0;
            // 当 1.result < -214748364时 2.result=-214748364且最后一位<-8时 溢出
            if (result < -214748364 || (result == -214748364 && pop < -8)) return 0;
            // 判断是否溢出结束

            result = result * 10 + pop;         // 原数值最后一位拼接到结果值
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}