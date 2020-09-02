package leetcode.editor.cn;
//判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
//
// 示例 1: 
//
// 输入: 121
//输出: true
// 
//
// 示例 2: 
//
// 输入: -121
//输出: false
//解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
// 
//
// 示例 3: 
//
// 输入: 10
//输出: false
//解释: 从右向左读, 为 01 。因此它不是一个回文数。
// 
//
// 进阶: 
//
// 你能不将整数转为字符串来解决这个问题吗？ 
// Related Topics 数学 
// 👍 1209 👎 0


public class PalindromeNumber{
    public static void main(String[] args){
        Solution solution = new PalindromeNumber().new Solution();
        System.out.println(solution.isPalindrome(15851));
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPalindrome(int x) {
        return isPalindrome2(x);
    }

    /**
     * 3.官方: 反转一半数字
     */
    public boolean isPalindrome3(int x) {
        // 1.小于0 2.末位为0时 返回false
        if ( x < 0 || (x % 10 == 0 && x != 0) ) {
            return false;
        }
        // 否则 反转一半数字 进行判断
        int temp = 0;
        // 当原数值小于等于 反转数字时 说明已经反转了一半(+1)
        while (x > temp) {
            temp = temp * 10 + x % 10;
            x = x / 10;
        }
        //System.out.println(x + "  " + temp);
        // 若原数值长度为奇数时x == temp/10, 偶数时x == temp
        return x == temp || x == temp/10;
    }

    /**
     * 2. 优化一下 反转一半数字(字符串)???  [66.11 68.07] [40.53 54.32]
     */
    public boolean isPalindrome2(int x) {
        if ( x < 0 || (x % 10 == 0 && x != 0) ) {
            return false;
        }
        boolean flag = true;

        char[] chars = String.valueOf(x).toCharArray();
        for (int i = 0; i < chars.length/2; i++) {
            if (chars[chars.length - i -1] != chars[i]) {
                flag = false;
                break;
            }
        }

        /*
        String str = String.valueOf(x);
        int length = str.length();
        char[] c1 = str.substring(0, length / 2).toCharArray();
        char[] c2 = str.substring(length - length / 2, length).toCharArray();

        for (int i = 0; i < c1.length; i++) {
            if (c1[c1.length - i - 1] != c2[i]) {
                flag = false;
                break;
            }
        }
        */

        return flag;
    }
    /**
     * 1. 自己写的代码 好垃圾.... 20.36 11.88
     */
    public boolean isPalindrome1(int x) {
        if ( x < 0 ) {
            return false;
        }
        String str1 = String.valueOf(x);
        String str2 = new StringBuilder(str1).reverse().toString();
        return str1.equals(str2);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}