package leetcode.sword.offer;
//请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
//
// 
//
// 示例 1： 
//
// 输入：s = "We are happy."
//输出："We%20are%20happy." 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 10000 
// 👍 39 👎 0


public class TiHuanKongGeLcof{
    public static void main(String[] args){
        Solution solution = new TiHuanKongGeLcof().new Solution();
        System.out.println(solution.replaceSpace("We are happy."));
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String replaceSpace(String s) {


        return replaceSpace2(s);
    }
    /**
     * 2.官方解法: 转存到另一个数组 遇到空格时保存为'%' '2' '0'
     * [100 15.43]
     */
    private String replaceSpace2(String s) {
        int length = s.length();                                    // 字符长度
        char[] characters = new char[length * 3];         // 创建一个原来数组三倍的新字符数组
        int index = 0;                  // 新数组的下标

        for (int i = 0; i < length; i++) {                          // 遍历原字符串
            char c = s.charAt(i);                                   // 当前字符
            if (c == ' ') {                                         // 遇到空格时 存储'%' '2' '0'
                characters[index++] = '%';
                characters[index++] = '2';
                characters[index++] = '0';
                continue;
            }
            characters[index++] = c;                                // 否则直接转存
        }

        String str = new String(characters, 0, index);
        return str;
    }

    /**
     * 1.使用字符串自带的replace函数
     */
    private String replaceSpace1(String s) {
        return s.replaceAll(" ", "%20");    // [16.46 11.79]
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}