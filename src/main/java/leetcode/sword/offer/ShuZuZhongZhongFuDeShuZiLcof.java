package leetcode.sword.offer;
//找出数组中重复的数字。
//
// 
//在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请
//找出数组中任意一个重复的数字。 
//
// 示例 1： 
//
// 输入：
//[2, 3, 1, 0, 2, 5, 3]
//输出：2 或 3 
// 
//
// 
//
// 限制： 
//
// 2 <= n <= 100000 
// Related Topics 数组 哈希表 
// 👍 160 👎 0


import java.util.HashSet;
import java.util.Set;

/**
 * 剑 03
 */
public class ShuZuZhongZhongFuDeShuZiLcof{
    public static void main(String[] args){
        Solution solution = new ShuZuZhongZhongFuDeShuZiLcof().new Solution();
        System.out.println(solution.findRepeatNumber(new int[]{2, 3, 1, 0, 2, 5, 3}));;
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findRepeatNumber(int[] nums) {
        return findRepeatNumber3(nums);
    }

    /**
     * 3. 哈哈哈哈呃... 一个不正经的想法 [69.25 97.80] [69.25 94.93]
     */
    public int findRepeatNumber3(int[] nums) {
        int length = nums.length;
        boolean[] nums2 = new boolean[length]; //[91.35 64.52]  // new boolean[100000]; [69.25 99.32]
        for (int num : nums) {      // 增强for循环更快?
            if ( nums2[num] == true ) {
                return num;
            }
            nums2[num] = true;
        }
        return -1;
    }

    /**
     * 2. 官方题解 (不是很理想啊0.0)  [41.02 13.92]
     */
    public int findRepeatNumber2(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        int repeat = -1;
        for (int num : nums) {
            if (!set.add(num)) {
                repeat = num;
                break;
            }
        }
        return repeat;
    }

    /**
     * 1.根据hash查找是否重复  重复的话返回 否则放入 [25.30 28.15] [7.15 25.44]
     */
    public int findRepeatNumber1(int[] nums) {
        Set hashSet = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if ( hashSet.contains(nums[i]) ) {
                return nums[i];
            }
            hashSet.add(nums[i]);
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}