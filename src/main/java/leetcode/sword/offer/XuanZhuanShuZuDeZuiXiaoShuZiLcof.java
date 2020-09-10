package leetcode.sword.offer;
//把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2
//] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。 
//
// 示例 1： 
//
// 输入：[3,4,5,1,2]
//输出：1
// 
//
// 示例 2： 
//
// 输入：[2,2,2,0,1]
//输出：0
// 
//
// 注意：本题与主站 154 题相同：https://leetcode-cn.com/problems/find-minimum-in-rotated-sor
//ted-array-ii/ 
// Related Topics 二分查找 
// 👍 148 👎 0

/**
 * 剑11 旋转数组的最小数字20200910
 */
public class XuanZhuanShuZuDeZuiXiaoShuZiLcof{
    public static void main(String[] args){
        Solution solution = new XuanZhuanShuZuDeZuiXiaoShuZiLcof().new Solution();
//        int[] nums = new int[]{3,4,5,-2,-1,0,1,2};
//        int[] nums = new int[]{3,4,5,1,2};
//        int[] nums = new int[]{2,2,2,0,1};
//        int[] nums = new int[]{3,1};
        int[] nums = new int[]{1};
//        int[] nums = new int[]{1,1};
//        int[] nums = new int[]{10,1,10,10,10};//10 10 10 1 10
        System.out.println(solution.minArray(nums));
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int minArray(int[] numbers) {
        return minArray2(numbers);
    }

    /**
     * 2.官方解法 [100 76.40] [100 99.07]
     */
    public int minArray2( int[] nums ) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int pivot = low + (high - low) / 2;
            if (nums[pivot] < nums[high]) {
                high = pivot;
            } else if (nums[pivot] > nums[high]) {
                low = pivot + 1;
            } else {
                high -= 1;
            }
        }
        return nums[low];
    }

    /**
     * 1.自己写的哦0.0 [44.72 65.27] [100 69.51] [44.72 25.94] [44.72 90.77] [100 99.89]??怎么回事
     *
     * 测试用例 [1] [1,3,5] [3,1,1] [3,1,3] [10,1,10,10,10] [2,2,2,0,1]
     */
    public int minArray1( int[] numbers ) {
        int left = 0;
        int right =  numbers.length - 1;
        if ( numbers[left] < numbers[right] ) return numbers[left];

        while ( left <= right ) {       // [3,4,5,1,2]
            int mid = (left + right) / 2;       // 这个定义到循环里快很多???

            if ( numbers[mid] > numbers[right] ) {      // 判断right和mid
                if ( mid == right - 1 || mid == right )
                    return numbers[right];
                left = mid;
            } else if ( numbers[mid] < numbers[right] ) {   // 1<3  right=mid=1 mid=0=left 3>1
                right = mid;
            } else {
                if ( mid == right - 1 || mid == right )
                    return numbers[right];
                right--;
            }
            //System.out.println(left + "---" + mid + "---" + right);
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}