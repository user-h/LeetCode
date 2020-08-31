package leetcode.editor.cn;
//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。 
//
// 
//
// 示例: 
//
// 给定 nums = [2, 7, 11, 15], target = 9
//
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回 [0, 1]
// 
// Related Topics 数组 哈希表 
// 👍 9017 👎 0


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1.两数之和
 */
public class TwoSum{
    public static void main(String[] args){
        Solution solution = new TwoSum().new Solution();
        int[] nums = new int[]{3, 3};
        int target = 6;
        int[] ints = solution.twoSum(nums, target);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        return twoSum3(nums, target);
    }
    /**
     * 1. 暴力遍历 时间复杂度O(n^2)
     */
    public int[] twoSum1(int[] nums, int target){
        int[] label = new int[2];
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = 0; j <  nums.length; j++) {
                if (nums[i] + nums[j] == target){
                    label[0] = i;
                    label[1] = j;
                }
            }
        }
        return label;
    }

    /**
     * 2. 数组排序
     * 先排序，然后两个指针i,j，i从前开始，j从后开始查找，当nums[i]+nums[j]>target时，j--；当nums[i]+nums[j]<target时，i++；注意排序后，之前的下标数字已经变化了。时间复杂度O(N*Log2N)
     */
    public int[] twoSum2(int[] nums, int target){
        int[] label = new int[2];   //保存查找到的两个数(下标)
        int[] nums2 = Arrays.copyOf(nums, nums.length);//原数组拷贝 1.clone 2.System.arraycopy 3.Arrays.copyOf 4.Arrays.copyOfRange
        Arrays.sort(nums2); //将拷贝数组进行排序
        int start = 0;  // 第一个数下标
        int end = nums.length-1;    // 第二个数下标
        int sum = 0;
        while (start <= end) {
            sum = nums2[start] + nums2[end];    // 两个下标数之和
            if (sum == target) {   // 和等于目标值 保存值并跳出循环
                label[0] = nums2[start];
                label[1] = nums2[end];
                //System.out.println(start + " " + end);
                //System.out.println(label[0] + " " + label[1]);
                break;
            } else if (sum > target) {  // 和大于目标值 第二个下标左移
                end --;
            } else {    // 和小于目标值 第一个下标右移
                start ++;
            }
        }
        // 遍历原数组 获取下标
        for (int i = 0; i < nums.length; i++) {
            if (label[0] == nums[i]) {
                label[0] = i;
            }
            if (label[1] == nums[i]) {
                label[1] = i;
            }
        }
        return label;
    }

    /**
     * 3. 利用空间换时间方式，用hashmap存储数组结构，key为值，value为下标。时间复杂度O(N)。
     * 局限:不能有重复值
     */
    public int[] twoSum3(int[] nums, int target){
        int[] label = new int[2];   // 保存结果
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < map.size(); i++) {
            if (map.containsKey(target - nums[i])) {     //map.get(target - nums[i]) != null
                label[0] = i;
                label[1] = map.get(target - nums[i]);
            }
        }
        return label;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}