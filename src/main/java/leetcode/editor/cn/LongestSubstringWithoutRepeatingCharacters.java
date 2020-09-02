package leetcode.editor.cn;
//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
//
// 示例 1: 
//
// 输入: "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window 
// 👍 4240 👎 0


import java.util.Arrays;

/**
 * 看不懂看不懂?????????????????????????  先从简单地开始吧0.0
 */
public class LongestSubstringWithoutRepeatingCharacters{
    public static void main(String[] args){
        Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));;
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        //a b c a b c d a d e
        //0 1 2 3 4 5 6 7 8 9
        int maxSize = 0;
        //记录ASCII 码字符出现的位置，以字符作为下标
        int[] dict = new int[128];
        //为了方便理解，这里把数组内容全部设为 -1，之后在记录的时候就可以从 0 开始，方便理解
        Arrays.fill(dict, -1);
        //用于记录重复 ASCII 码字符出现的位置的值
        int repeatValue = -1;
        // 当前下标
        int i = 0;
        int ASCII;
        while (i < s.length()) {
            ASCII = s.charAt(i);
            //如果当前位置的值 > repeatValue，证明当前位置已经赋过一次值了，证明字符重复
            if (dict[ASCII] > repeatValue)
                //更新 repeatValue 为之前赋值的下标
                repeatValue = dict[ASCII];
            //将当前下标赋值到数组相应位置
            dict[ASCII] = i;
            //i - repeatValue(去除重复部分)
            // 比如 abcabcdade 中的三个 a 的计算  abca - a(3 - 0)=bca   abcabcda - abca(7 - 3)=bcda
            maxSize = Math.max(maxSize, i - repeatValue);
            //s.length() - repeatValue - 1 判断剩下的数有没有必要继续循环
            //比如 abcabcdade 最后的 a(当 i = 7 repeatValue = 3) ，abcabcdade - abca(10-3-1) = bcdade  剩下最多有六位
            //比如 abcabcdade 最后的 d(当 i = 8 repeatValue = 6) ，abcabcdade - abcabcd(10-6-1) = ade  剩下最多也是三位
            if (maxSize >= s.length() - repeatValue - 1) {
                return maxSize;
            }
            i++;
        }
        return maxSize;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}