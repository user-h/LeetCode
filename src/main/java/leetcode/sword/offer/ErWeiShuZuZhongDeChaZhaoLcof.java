package leetcode.sword.offer;
//在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，
//判断数组中是否含有该整数。 
//
// 
//
// 示例: 
//
// 现有矩阵 matrix 如下： 
//
// [
//  [1,   4,  7, 11, 15],
//  [2,   5,  8, 12, 19],
//  [3,   6,  9, 16, 22],
//  [10, 13, 14, 17, 24],
//  [18, 21, 23, 26, 30]
//]
// 
//
// 给定 target = 5，返回 true。 
//
// 给定 target = 20，返回 false。 
//
// 
//
// 限制： 
//
// 0 <= n <= 1000 
//
// 0 <= m <= 1000 
//
// 
//
// 注意：本题与主站 240 题相同：https://leetcode-cn.com/problems/search-a-2d-matrix-ii/ 
// Related Topics 数组 双指针 
// 👍 134 👎 0

/**
 * 剑 04
 */
public class ErWeiShuZuZhongDeChaZhaoLcof{
    public static void main(String[] args){
        Solution solution = new ErWeiShuZuZhongDeChaZhaoLcof().new Solution();
        int[][] matrix = new int[][]{
                {1,  4,  7,  11, 15},
                {2,  5,  8,  12, 19},
                {3,  6,  9,  16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        System.out.println(solution.findNumberIn2DArray(matrix, 5));;
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        return findNumberIn2DArray2(matrix, target);
    }
    /**
     * 2. 转化成图 类似二叉搜索树  [100 56][100 86.49]
     * matrix[row=0][col=4] = 15  1.若target>15 row++去掉第一行
     *                            2.若target<15 col--去掉第最后一列
     *          15
     *        11  19
     *      7   12  22
     *    4   8   16  24
     *  1   5   9  17  30
     *    2   6  14  26
     *      3  13  23
     *       10  21
     *         18
     */
    public boolean findNumberIn2DArray2(int[][] matrix, int target) {
        int totalRow = matrix.length;           // 保存总行数
        if (totalRow==0) return false;          // 这里先排除空矩阵 要不后面matrix[0]会下标越界
        int totalCol = matrix[0].length;        // 保存总列数

        int row = 0;                            // 起始点横坐标
        int col = totalCol-1;                   // 起始点纵坐标

        while ( col >= 0 && row < totalRow ) {          // 当坐标不超过矩阵的边界
            if ( target > matrix[row][col] )            // 若target>matrix[row][col] row++去掉第一行
                row++;
            else if ( target < matrix[row][col] )       // 若target<matrix[row][col] col--去掉第最后一列
                col--;
            else                                        // 若target=matrix[row][col] 则找到返回true
                return true;
        }
        
        return false;
    }

    /**
     * 1. 暴力遍历 O(mn)
     * 没有利用矩阵[从左到右递增,从上到下递增]特点
     * [16.05 73.05] [16.05 60.42]
     */
    public boolean findNumberIn2DArray1(int[][] matrix, int target) {
        boolean flag = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length ; j++) {
                if (matrix[i][j] == target) {
                    flag = true;
                    break;
                }
            }
        }
        return flag;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}