package leetcode.sword.offer;
//写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。斐波那契数列的定义如下：
//
// F(0) = 0,   F(1) = 1
//F(N) = F(N - 1) + F(N - 2), 其中 N > 1. 
//
// 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。 
//
// 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。 
//
// 
//
// 示例 1： 
//
// 输入：n = 2
//输出：1
// 
//
// 示例 2： 
//
// 输入：n = 5
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 100 
// 
//
// 注意：本题与主站 509 题相同：https://leetcode-cn.com/problems/fibonacci-number/ 
// Related Topics 递归 
// 👍 58 👎 0


public class FeiBoNaQiShuLieLcof{
    public static void main(String[] args){
        Solution solution = new FeiBoNaQiShuLieLcof().new Solution();
        System.out.println(solution.fib(3));
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int fib(int n) {
        return fib1(n);
    }

    /**
     * 1.官网解法 [100 76.11] [100 66.16]
     */
    public int fib1(int n) {
        int a = 0, b = 1, sum;              // 第n-2项和第n-1项 第n项
        for(int i = 0; i < n; i++){
            sum = (a + b) % 1000000007;     // 第n项 = [(n-2)项 + (n-1)项] % 1000000007
            a = b;                          // 把第n-1项 赋值给a 作为n-2项
            b = sum;                        // 把第n项 赋值给b 作为n-1项
            //System.out.println(a + "==" + b + "==" + sum);
        }

        // 0 1 1 2 3
        // 若n==0,不执行循环返回a=0  n==1,执行1次,返回a=b=1  n==3时,执行3次循环 b=sum=3 a=2
        // 实际上每次循环算的是第n+1项
        return a;
    }

    /**
     * 想岔了.......
     * 92===7540113804746346429
     * 93===-6246583658587674878
     */
    /*public int fib2(int n) {
        //if ( n==null ) return -1;
        if ( n==0 ) return 0;
        if ( n==1 ) return 1;

        ArrayList<BigInteger> nums = new ArrayList<>();
        nums.add(new BigInteger("0"));
        nums.add(new BigInteger("1"));
        for (int i = 2; i <= n; i++) {
            nums.add(i, nums.get(i-1).add(nums.get(i-2)));
            System.out.println(i + "===" + nums.get(i));
        }
        BigInteger res = nums.get(n);
        BigInteger temp = new BigInteger("1000000007");
        if ( res.compareTo(temp) != -1 ) res = res.divideAndRemainder(temp)[1];
        return res.intValue();
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)

}