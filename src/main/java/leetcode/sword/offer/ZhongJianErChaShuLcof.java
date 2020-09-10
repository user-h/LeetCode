package leetcode.sword.offer;
//输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
//
// 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 5000 
//
// 
//
// 注意：本题与主站 105 题重复：https://leetcode-cn.com/problems/construct-binary-tree-from-
//preorder-and-inorder-traversal/ 
// Related Topics 树 递归 
// 👍 192 👎 0

import java.util.*;

/**
 * 重建二叉树
 * 学习一下代码(自己不会啊QAQ)
 */
public class ZhongJianErChaShuLcof{
    public static void main(String[] args){
        Solution solution = new ZhongJianErChaShuLcof().new Solution();
        int[] preorder = new int[]{3,9,20,15,7};        // 前序遍历
        int[] inorder = new int[]{9,3,15,20,7};         // 中序遍历
        TreeNode treeNode = solution.buildTree(preorder, inorder);
        TreeOperation.show(treeNode);
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
    /*public TreeNode buildTree(int[] preorder, int[] inorder) {

    }*/

    /**
     * 官方解答
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {                         // 若数组为空 返回null
            return null;
        }
        Map<Integer, Integer> indexMap = new HashMap<Integer, Integer>();       // key保存节点值 value保存节点下标[中序: 左-根-右]
        int length = preorder.length;                                           // 获取总结点数
        for (int i = 0; i < length; i++) {
            indexMap.put(inorder[i], i);                                        // 放入中序遍历的节点值和中序遍历下标
        }
        // 递归创建二叉树
        TreeNode root = buildTree(preorder, 0, length - 1, inorder, 0, length - 1, indexMap);
        return root;
    }

    /**
     * 递归创建二叉树
     * 参数: 前序 [前序起始下标 前序结束下标] 中序 [中序起始下标 中序结束下标] 用来保存中序节点值和下标的Map集合
     * // 前序遍历 preorder = [3,9,20,15,7]
     * // 中序遍历 inorder = [9,3,15,20,7]
     */
    public TreeNode buildTree(int[] preorder, int preorderStart, int preorderEnd, int[] inorder, int inorderStart, int inorderEnd, Map<Integer, Integer> indexMap) {
        if (preorderStart > preorderEnd) return null;               // 起始位置>结束位置 返回null

        int rootVal = preorder[preorderStart];                      // 前序[0] 为根节点
        TreeNode root = new TreeNode(rootVal);                      // 创建[子树]根节点
        if (preorderStart == preorderEnd) {                         // 若起始==结束 说明只有一个节点了  没有子树了
            return root;
        } else {                                                    // 否则的话 创建子树
            int rootIndex = indexMap.get(rootVal);                  // 获取根节点[中序]的下标 用其划分左右子树[比下标小的在左子树上 比下标大的在右子树上]
            // 中序 左子树:1=1-0 [9]  右子树:3=4-1 [15 20 7]
            int leftNodes = rootIndex - inorderStart, rightNodes = inorderEnd - rootIndex;
            // 创建左子树 buildTree([前序 0+1 0+1] [中序 0 0+0])
            TreeNode leftSubtree = buildTree(preorder, preorderStart + 1, preorderStart + leftNodes, inorder, inorderStart, rootIndex - 1, indexMap);
            // 创建右子树 buildTree([前序 4-3+1 4] [中序 1+1 4])
            TreeNode rightSubtree = buildTree(preorder, preorderEnd - rightNodes + 1, preorderEnd, inorder, rootIndex + 1, inorderEnd, indexMap);
            // 把左子树和右子树连接到根节点上
            root.left = leftSubtree;
            root.right = rightSubtree;
            return root;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}