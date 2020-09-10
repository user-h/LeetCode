package leetcode.editor.cn;
//给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
//
// 例如： 
//给定二叉树 [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其自底向上的层次遍历为： 
//
// [
//  [15,7],
//  [9,20],
//  [3]
//]
// 
// Related Topics 树 广度优先搜索 
// 👍 314 👎 0


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 107 二叉树的层次遍历 II
 *
 * 学习过后自己写102题......
 */
public class BinaryTreeLevelOrderTraversalIi{
    public static void main(String[] args){
        Solution solution = new BinaryTreeLevelOrderTraversalIi().new Solution();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        // TreeOperation.show(root);     // 打印树形结构

        System.out.println(solution.levelOrderBottom(root));

    }
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    /**
     * 1.学习官方解法 [98.25 25.85]
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();       // 创建保存结果的列表
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();                 // 创建队列保存二叉树节点(某一层)
        queue.offer(root);
        while (!queue.isEmpty()) {                                          // 当队列不空时执行循环
            List<Integer> level = new ArrayList<Integer>();                 // 创建保存某一层节点值的集合
            int size = queue.size();
            for (int i = 0; i < size; i++) {                                // 遍历队列
                TreeNode node = queue.poll();                               // 检索并删除队列头(出队列)
                level.add(node.val);                                        // 把节点值保存进列表
                // 如果有左右节点 则把左右节点放入队列
                TreeNode left = node.left, right = node.right;
                if (left != null) {
                    queue.offer(left);
                }
                if (right != null) {
                    queue.offer(right);
                }
            }
            result.add(0, level);                                      // 头插法 插入结果
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}