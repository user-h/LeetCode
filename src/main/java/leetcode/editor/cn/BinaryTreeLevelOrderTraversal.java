package leetcode.editor.cn;
//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
//
// 
//
// 示例： 
//二叉树：[3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层次遍历结果： 
//
// [
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索 
// 👍 620 👎 0


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 102. 二叉树的层序遍历20200906
 */
public class BinaryTreeLevelOrderTraversal{
    public static void main(String[] args){
        Solution solution = new BinaryTreeLevelOrderTraversal().new Solution();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(solution.levelOrder(root));
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
     * 学习107题目 自己写一遍
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();       // 创建结果集
        if (root == null) return results;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();                 // 创建队列
        queue.offer(root);                                                  // 放入根节点

        int size = queue.size();
        /**
         * 队列[root]
         * 队列[root.left root.right]
         * 队列[root.right.left root.right.left]
         */
        while ( size != 0 ) {
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();                         // 弹出队首
                list.add(treeNode.val);                                   // 保存左右子节点的集合

                TreeNode leftNode = treeNode.left;
                TreeNode rightNode = treeNode.right;
                if (leftNode != null) queue.offer(leftNode);
                if (rightNode != null) queue.offer(rightNode);
            }
            size = queue.size();                                      // 获取新的长度
            //System.out.println(size);

            results.add(list);                                        // 加入结果集
        }
        return results;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}